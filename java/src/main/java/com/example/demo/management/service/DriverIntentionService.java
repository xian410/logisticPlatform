package com.example.demo.management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.management.entity.DriverIntention;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.management.entity.Goods;
import com.example.demo.management.entity.request.*;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import com.example.demo.management.entity.response.SelectIttentionListResponse;

/**
 * <p>
 * 司机意向表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface DriverIntentionService extends IService<DriverIntention> {
    /**
     * 添加司机有意
     * @param addDriverIntentionRequest 表单  loginId 司机Id
     */
    void addIntention(AddDriverIntentionRequest addDriverIntentionRequest, String loginId);


    /**
     * 删除有意表
     * @param intentionId
     */
    void deleteIntention(String intentionId);

    /**
     * 查看所有有意表
     */

    /**
     * 司机自己的有意表
     */
    IPage<SelectIttentionListResponse> selectDriverIntention(SelectIntentionRequest selectIntentionRequest, String driverId);

    /**
     * 货主查看自己货物的有意司机
     */
    IPage<SelectIttentionListResponse> selectCustomerIntention(SelectIntentionRequest selectIntentionRequest,String customerId);
}
