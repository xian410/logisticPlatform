package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.Customer;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.constact.Common;
import com.example.demo.management.entity.enums.GenderEnum;
import com.example.demo.management.entity.request.ChangePasswordRequest;
import com.example.demo.management.entity.request.CustomerInfoRequest;
import com.example.demo.management.entity.response.CustomerInfoResponse;
import com.example.demo.management.mapper.CustomerMapper;
import com.example.demo.management.mapper.LoginUserMapper;
import com.example.demo.management.service.CustomerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 货主信息表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper, Customer> implements CustomerService {

    @Resource
    CustomerMapper customerMapper;

    @Resource
    LoginUserMapper loginUserMapper;

    @Override
    public void modCustomerInfo(CustomerInfoRequest customerInfoRequest, String customerId) {
        Customer customer = customerMapper.selectOne(
                Wrappers.lambdaQuery(Customer.class)
                        .eq(Customer::getCustomerId, customerId)
        );
        BeanUtils.copyProperties(customerInfoRequest, customer);
        customerMapper.updateById(customer);
    }


    @Override
    public CustomerInfoResponse getCustomerInfo(String customerId) {
        Customer customer = customerMapper.selectOne(
                Wrappers.lambdaQuery(Customer.class)
                .eq(Customer::getCustomerId, customerId)
        );
        CustomerInfoResponse customerInfoResponse = new CustomerInfoResponse();
        BeanUtils.copyProperties(customer,customerInfoResponse);
        customerInfoResponse.setGender(GenderEnum.getMessageByGender(customer.getGender()));
        return customerInfoResponse;
    }


}
