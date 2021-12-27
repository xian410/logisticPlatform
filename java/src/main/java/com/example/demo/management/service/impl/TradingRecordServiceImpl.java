package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.management.entity.Customer;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.TradingRecord;
import com.example.demo.management.entity.constact.Prefix;
import com.example.demo.management.entity.request.AddTradingRecordRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import com.example.demo.management.entity.response.SelectOrdersResponse;
import com.example.demo.management.entity.response.SelectTradingRecordResponse;
import com.example.demo.management.mapper.CustomerMapper;
import com.example.demo.management.mapper.DriverMapper;
import com.example.demo.management.mapper.LoginUserMapper;
import com.example.demo.management.mapper.TradingRecordMapper;
import com.example.demo.management.service.CustomerService;
import com.example.demo.management.service.DriverService;
import com.example.demo.management.service.LoginUserService;
import com.example.demo.management.service.TradingRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 交易记录表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class TradingRecordServiceImpl extends ServiceImpl<TradingRecordMapper, TradingRecord> implements TradingRecordService {

    @Resource
    TradingRecordMapper tradingRecordMapper;

    @Resource
    LoginUserService loginUserService;

    @Resource
    CustomerService customerService;

    @Resource
    DriverService driverService;

    @Override
    public void addRecord(AddTradingRecordRequest addTradingRecordRequest) {
        TradingRecord tradingRecord = new TradingRecord();
        tradingRecord.setTradeId(Prefix.TRADE_PREFIX + UUID.randomUUID());
        BeanUtils.copyProperties(addTradingRecordRequest,tradingRecord);
        tradingRecordMapper.insert(tradingRecord);
    }

    @Override
    public IPage<SelectTradingRecordResponse> selectTradingRecord(String loginId, PageRequest pageRequest) {
        IPage<SelectTradingRecordResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(pageRequest.getCurrent());
        queryPageRequest.setSize(pageRequest.getSize());

        IPage<SelectTradingRecordResponse> page  = tradingRecordMapper.selectTradingRecord(queryPageRequest,loginId);

        List<SelectTradingRecordResponse> list = page.getRecords();

        list.forEach(record -> {

            //sources
            String sources = record.getSources();
            if ("0".equals(sources)) {
                record.setName("系统充值");
            } else {
                //判断用户类型获取姓名
                  int userType = loginUserService.getUserType(sources);
                  if (userType == 0) {
                        record.setName(customerService.getCustomerInfo(sources).getName());
                  } else {
                      record.setName(driverService.getDriverInfo(sources).getName());
                  }
            }
        });
        page.setRecords(list);
        return page;

    }

    @Override
    public IPage<SelectTradingRecordResponse> selectAllTradingRecord(PageRequest pageRequest) {
        IPage<SelectTradingRecordResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(pageRequest.getCurrent());
        queryPageRequest.setSize(pageRequest.getSize());

        IPage<SelectTradingRecordResponse> page  = tradingRecordMapper.selectAllTradingRecord(queryPageRequest);

        List<SelectTradingRecordResponse> list = page.getRecords();

        list.forEach(record -> {
            //sources
            String sources = record.getSources();
            if ("0".equals(sources)) {
                record.setName("系统充值");
                record.setOrderId("无");
                int userType1 = loginUserService.getUserType(record.getLoginId());
                if (userType1 == 0) {
                    record.setMyName(customerService.getCustomerInfo(record.getLoginId()).getName());
                }else {
                    record.setMyName(driverService.getDriverInfo(record.getLoginId()).getName());
                }
            } else {
                //判断用户类型获取姓名
                int userType = loginUserService.getUserType(sources);
                if (userType == 0) {
                    record.setName(customerService.getCustomerInfo(sources).getName());
                    record.setMyName(driverService.getDriverInfo(record.getLoginId()).getName());
                } else {
                    record.setName(driverService.getDriverInfo(sources).getName());
                    record.setMyName(customerService.getCustomerInfo(record.getLoginId()).getName());
                }
            }
        });
        page.setRecords(list);
        return page;
    }

    @Override
    public void delTrade(String tradeId) {
        tradingRecordMapper.delete(new UpdateWrapper<TradingRecord>().eq("trade_id", tradeId));
    }

}
