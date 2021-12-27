package com.example.demo.management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.management.entity.TradingRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.management.entity.request.AddTradingRecordRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.response.SelectTradingRecordResponse;

/**
 * <p>
 * 交易记录表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface TradingRecordService extends IService<TradingRecord> {

    /**
     * 添加交易记录
     * status：
     * 1：充值
     * 2：货主付款
     * 3：司机收款
     * @param addTradingRecordRequest
     */
    void addRecord(AddTradingRecordRequest addTradingRecordRequest);

    /**
     * 司机查看交易记录
     * @param loginId
     */
    IPage<SelectTradingRecordResponse> selectTradingRecord(String loginId, PageRequest pageRequest);

    /**
     * 管理员查看全部交易记录
     * @param pageRequest
     * @return
     */
    IPage<SelectTradingRecordResponse> selectAllTradingRecord(PageRequest pageRequest);

    /**
     * 管理员删除交易记录
     * @param tradeId
     */
    void delTrade(String tradeId);
}
