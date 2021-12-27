package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.*;
import com.example.demo.management.entity.constact.Common;
import com.example.demo.management.entity.constact.Prefix;
import com.example.demo.management.entity.enums.GenderEnum;
import com.example.demo.management.entity.request.*;
import com.example.demo.management.entity.response.SelectIttentionListResponse;
import com.example.demo.management.entity.response.SelectOrdersResponse;
import com.example.demo.management.mapper.DriverIntentionMapper;
import com.example.demo.management.mapper.OrdersMapper;
import com.example.demo.management.service.AccountService;
import com.example.demo.management.service.MessageService;
import com.example.demo.management.service.OrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.management.service.TradingRecordService;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 订单信息表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements OrdersService {

    @Resource
    OrdersMapper ordersMapper;

    @Resource
    DriverIntentionMapper driverIntentionMapper;

    @Resource
    TradingRecordService tradingRecordService;

    @Resource
    AccountService accountService;

    @Resource
    MessageService messageService;

    @Override
    public void addOrders(AddOrderRequest addOrderRequest, String loginId) {
        Orders orders = new Orders();
        BeanUtils.copyProperties(addOrderRequest,orders);
        orders.setCustomerId(loginId);
        orders.setOrderId(Prefix.ORDER_PREFIX + UUID.randomUUID());

        if (accountService.queryMoney(loginId) < orders.getFees()) {
            throw new CustomException("账户余额不足，请充值");
        }

        ordersMapper.insert(orders);
        //司机有意表状态改变
        DriverIntention driverIntention = new DriverIntention();

        //选中的标志位
        driverIntention.setStatus(Common.INTENTION_CHOOSE);
        LambdaQueryWrapper<DriverIntention> qw = new LambdaQueryWrapper<>();
        qw.eq(DriverIntention::getIntentionId,addOrderRequest.getIntentionId());
        driverIntentionMapper.update(driverIntention,qw);

        //未选中的标志位
        driverIntention.setStatus(Common.INTENTION_IGNORE);
        LambdaQueryWrapper<DriverIntention> qw1 = new LambdaQueryWrapper<>();

        qw1.eq(DriverIntention::getGoodId,addOrderRequest.getGoodId());
        qw1.ne(DriverIntention::getIntentionId,addOrderRequest.getIntentionId());

        driverIntentionMapper.update(driverIntention,qw1);


        //付款
        accountService.modMoney(loginId,orders.getFees()*-1);

        //增加交易记录
        AddTradingRecordRequest addTradingRecordRequest = new AddTradingRecordRequest();
        addTradingRecordRequest.setLoginId(loginId);
        addTradingRecordRequest.setStatus(Common.PAY);
        addTradingRecordRequest.setOrderId(orders.getOrderId());
        addTradingRecordRequest.setSources(orders.getDriverId());
        addTradingRecordRequest.setFees(orders.getFees()*-1);
        tradingRecordService.addRecord(addTradingRecordRequest);

        //添加第三类消息记录  报价被接受
        AddMessageRequest addMessageRequest = new AddMessageRequest();
        addMessageRequest.setLoginId(addOrderRequest.getDriverId());
        addMessageRequest.setFromUserId(loginId);
        addMessageRequest.setGoodId(addOrderRequest.getGoodId());
        addMessageRequest.setStatus(3);
        messageService.addMessage(addMessageRequest);

        //添加第四类消息记录  报价被拒绝
        List<DriverIntention> list = driverIntentionMapper.selectList(qw1);
        list.forEach(driverIntention1 -> {
            AddMessageRequest addMessageRequest1 = new AddMessageRequest();
            addMessageRequest1.setLoginId(driverIntention1.getDriverId());
            addMessageRequest1.setFromUserId(loginId);
            addMessageRequest1.setGoodId(addOrderRequest.getGoodId());
            addMessageRequest1.setStatus(4);
            messageService.addMessage(addMessageRequest1);
        });
    }

    @Override
    public void checkOrders(String goodId) {
        String goodId1 = goodId.substring(1,goodId.length()-1);
        Orders orders = ordersMapper.selectOne(
                Wrappers.lambdaQuery(Orders.class)
                        .eq(Orders::getGoodId,goodId1)
        );
        if (orders != null) {
            throw new CustomException(1,"货物已生成订单，不可修改");
        }
    }

    @Override
    public void modifyOrders(AddOrderRequest addOrderRequest, String loginId) {
        Orders orders = new Orders();
        orders.setStatus(addOrderRequest.getStatus());
        LambdaQueryWrapper<Orders> qw = new LambdaQueryWrapper<>();
        qw.eq(Orders::getOrderId, addOrderRequest.getOrderId());

        ordersMapper.update(orders,qw);
        orders = ordersMapper.selectOne(Wrappers.lambdaQuery(Orders.class)
                                                .eq(Orders::getOrderId,addOrderRequest.getOrderId()));

        if (addOrderRequest.getStatus() == 1) {
            //添加第二类消息记录
            AddMessageRequest addMessageRequest = new AddMessageRequest();
            addMessageRequest.setLoginId(orders.getCustomerId());
            addMessageRequest.setFromUserId(loginId);
            addMessageRequest.setGoodId(orders.getGoodId());
            addMessageRequest.setStatus(2);
            messageService.addMessage(addMessageRequest);
        }

        //2表示货主确认订单，可以钱可以到司机的账上了
        if (addOrderRequest.getStatus() == 2) {
            //转款
            accountService.modMoney(orders.getDriverId(),orders.getFees());
            //增加交易记录
            AddTradingRecordRequest addTradingRecordRequest = new AddTradingRecordRequest();
            addTradingRecordRequest.setLoginId(orders.getDriverId());
            addTradingRecordRequest.setStatus(Common.RECEIVE);
            addTradingRecordRequest.setOrderId(orders.getOrderId());
            addTradingRecordRequest.setSources(orders.getCustomerId());
            addTradingRecordRequest.setFees(orders.getFees());
            tradingRecordService.addRecord(addTradingRecordRequest);

            //添加第五类消息记录
            AddMessageRequest addMessageRequest = new AddMessageRequest();
            addMessageRequest.setLoginId(orders.getDriverId());
            addMessageRequest.setFromUserId(loginId);
            addMessageRequest.setGoodId(orders.getGoodId());
            addMessageRequest.setStatus(5);
            messageService.addMessage(addMessageRequest);
        }

    }

    @Override
    public void deleteOrders(String orderId) {
        Orders orders = ordersMapper.selectOne(Wrappers.lambdaQuery(Orders.class)
                .eq(Orders::getOrderId, orderId));
        if (orders == null) {
            throw new CustomException("该订单不存在");
        }
        ordersMapper.delete(Wrappers.lambdaQuery(Orders.class)
                .eq(Orders::getOrderId, orderId));
    }

    @Override
    public IPage<SelectOrdersResponse> selectDriverOrders(SelectOrdersRequest selectOrdersRequest,String driverId) {
        IPage<SelectOrdersResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectOrdersRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectOrdersRequest.getPageRequest().getSize());

        IPage<SelectOrdersResponse> page  = ordersMapper.selectDriverOrders(queryPageRequest, selectOrdersRequest,driverId);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<SelectOrdersResponse> list = page.getRecords();
        list.forEach(selectIttentionListResponse ->{
            selectIttentionListResponse.setGender(GenderEnum.getMessageByGender(Integer.parseInt(selectIttentionListResponse.getGender())));
            //日期格式化
            String date = dtf.format(selectIttentionListResponse.getDriverCreateTime());
            selectIttentionListResponse.setDriverCreateTime1(date);
        });
        page.setRecords(list);
        return page;
    }

    @Override
    public IPage<SelectOrdersResponse> selectCustomerOrders(SelectOrdersRequest selectOrdersRequest,String customerId) {
        IPage<SelectOrdersResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectOrdersRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectOrdersRequest.getPageRequest().getSize());

        IPage<SelectOrdersResponse> page  = ordersMapper.selectCustomerOrders(queryPageRequest, selectOrdersRequest,customerId);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<SelectOrdersResponse> list = page.getRecords();
        list.forEach(selectIttentionListResponse ->{
            selectIttentionListResponse.setGender(GenderEnum.getMessageByGender(Integer.parseInt(selectIttentionListResponse.getGender())));
            //日期格式化
            String date = dtf.format(selectIttentionListResponse.getDriverCreateTime());
            selectIttentionListResponse.setDriverCreateTime1(date);
        });
        page.setRecords(list);
        return page;
    }

    @Override
    public IPage<SelectOrdersResponse> selectAllOrders(SelectOrdersRequest selectOrdersRequest) {
        IPage<SelectOrdersResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectOrdersRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectOrdersRequest.getPageRequest().getSize());
        IPage<SelectOrdersResponse> selectOrdersResponseIPage = ordersMapper.selectAllOrders(queryPageRequest, selectOrdersRequest);
        return selectOrdersResponseIPage;
    }
}
