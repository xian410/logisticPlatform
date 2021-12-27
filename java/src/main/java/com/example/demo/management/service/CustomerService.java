package com.example.demo.management.service;

import com.example.demo.management.entity.Customer;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.management.entity.request.ChangePasswordRequest;
import com.example.demo.management.entity.request.CustomerInfoRequest;
import com.example.demo.management.entity.response.CustomerInfoResponse;

/**
 * <p>
 * 货主信息表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface CustomerService extends IService<Customer> {

    /**
     * 修改个人信息
     * @param customerInfoRequest
     * @param customerId
     */
    void modCustomerInfo(CustomerInfoRequest customerInfoRequest, String customerId);


    CustomerInfoResponse getCustomerInfo(String customerId);
}
