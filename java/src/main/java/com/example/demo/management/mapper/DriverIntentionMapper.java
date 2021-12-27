package com.example.demo.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.management.entity.DriverIntention;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.management.entity.request.SelectIntentionRequest;
import com.example.demo.management.entity.response.SelectIttentionListResponse;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 司机意向表 Mapper 接口
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface DriverIntentionMapper extends BaseMapper<DriverIntention> {

    /**
     * 货主查看有意表
     */
    IPage<SelectIttentionListResponse> selectCustomerIntention(IPage<SelectIttentionListResponse> queryPageRequest,
                                                      @Param("selectIntentionRequest") SelectIntentionRequest selectIntentionRequest,
                                                      @Param("customerId") String customerId);

    /**
     * 司机查看有意表
     */
    IPage<SelectIttentionListResponse> selectDriverIntention(IPage<SelectIttentionListResponse> queryPageRequest,
                                                      @Param("selectIntentionRequest") SelectIntentionRequest selectIntentionRequest,
                                                      @Param("driverId") String driverId);

}
