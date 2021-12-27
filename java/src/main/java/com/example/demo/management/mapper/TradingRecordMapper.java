package com.example.demo.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.management.entity.TradingRecord;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.management.entity.request.SelectOrdersRequest;
import com.example.demo.management.entity.response.SelectOrdersResponse;
import com.example.demo.management.entity.response.SelectTradingRecordResponse;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 交易记录表 Mapper 接口
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface TradingRecordMapper extends BaseMapper<TradingRecord> {

    /**
     * 司机查看订单
     */
    IPage<SelectTradingRecordResponse> selectTradingRecord(IPage<SelectTradingRecordResponse> queryPageRequest,
                                                   @Param("loginId") String loginId);


    IPage<SelectTradingRecordResponse> selectAllTradingRecord(IPage<SelectTradingRecordResponse> queryPageRequest);
}
