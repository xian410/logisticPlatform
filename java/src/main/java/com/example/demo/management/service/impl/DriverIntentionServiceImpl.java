package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.DriverIntention;
import com.example.demo.management.entity.Orders;
import com.example.demo.management.entity.constact.Prefix;
import com.example.demo.management.entity.enums.GenderEnum;
import com.example.demo.management.entity.request.AddDriverIntentionRequest;
import com.example.demo.management.entity.request.AddMessageRequest;
import com.example.demo.management.entity.request.SelectIntentionRequest;
import com.example.demo.management.entity.response.SelectIttentionListResponse;
import com.example.demo.management.mapper.DriverIntentionMapper;
import com.example.demo.management.mapper.OrdersMapper;
import com.example.demo.management.service.DriverIntentionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.management.service.MessageService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.xml.crypto.Data;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 司机意向表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class DriverIntentionServiceImpl extends ServiceImpl<DriverIntentionMapper, DriverIntention> implements DriverIntentionService {

    @Resource
    DriverIntentionMapper driverIntentionMapper;

    @Resource
    MessageService messageService;

    @Resource
    OrdersMapper ordersMapper;

    @Override
    public void addIntention(AddDriverIntentionRequest addDriverIntentionRequest, String loginId) {
        DriverIntention driverIntention = new DriverIntention();
        BeanUtils.copyProperties(addDriverIntentionRequest,driverIntention);
        driverIntention.setDriverId(loginId);
        driverIntention.setIntentionId(Prefix.INTENTION_PREFIX + UUID.randomUUID());
        driverIntentionMapper.insert(driverIntention);

        //添加第一类消息记录
        AddMessageRequest addMessageRequest = new AddMessageRequest();
        addMessageRequest.setLoginId(addDriverIntentionRequest.getCustomerId());
        addMessageRequest.setFromUserId(loginId);
        addMessageRequest.setGoodId(addDriverIntentionRequest.getGoodId());
        addMessageRequest.setStatus(1);
        messageService.addMessage(addMessageRequest);
    }


    @Override
    public void deleteIntention(String intentionId) {
        DriverIntention driverIntention = driverIntentionMapper.selectOne(Wrappers.lambdaQuery(DriverIntention.class)
                .eq(DriverIntention::getIntentionId, intentionId));
        if (driverIntention == null) {
            throw new CustomException(1,"该目标不存在");
        }
        List<Orders> orders = ordersMapper.selectList(new QueryWrapper<Orders>().eq("intention_id", intentionId));
        if (orders.size() != 0 && driverIntention.getStatus() == 2) {
            throw new CustomException(1,"已形成订单，不可删除");
        }
        driverIntentionMapper.delete(Wrappers.lambdaQuery(DriverIntention.class)
                .eq(DriverIntention::getIntentionId, intentionId));
    }

    @Override
    public IPage<SelectIttentionListResponse> selectDriverIntention(SelectIntentionRequest selectIntentionRequest, String driverId) {
        IPage<SelectIttentionListResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectIntentionRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectIntentionRequest.getPageRequest().getSize());

        IPage<SelectIttentionListResponse> page  = driverIntentionMapper.selectDriverIntention(queryPageRequest, selectIntentionRequest,driverId);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<SelectIttentionListResponse> list = page.getRecords();
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
    public IPage<SelectIttentionListResponse> selectCustomerIntention(SelectIntentionRequest selectIntentionRequest, String customerId) {
        IPage<SelectIttentionListResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectIntentionRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectIntentionRequest.getPageRequest().getSize());

        IPage<SelectIttentionListResponse> page  = driverIntentionMapper.selectCustomerIntention(queryPageRequest, selectIntentionRequest,customerId);

        //日期格式化
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<SelectIttentionListResponse> list = page.getRecords();
        list.forEach(selectIttentionListResponse ->{
            selectIttentionListResponse.setGender(GenderEnum.getMessageByGender(Integer.parseInt(selectIttentionListResponse.getGender())));
            //日期格式化
            String date = dtf.format(selectIttentionListResponse.getDriverCreateTime());
            selectIttentionListResponse.setDriverCreateTime1(date);
        });
        page.setRecords(list);
        return page;
    }


}
