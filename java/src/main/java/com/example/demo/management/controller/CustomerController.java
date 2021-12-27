package com.example.demo.management.controller;


import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.request.ChangePasswordRequest;
import com.example.demo.management.entity.request.CustomerInfoRequest;
import com.example.demo.management.entity.response.CustomerInfoResponse;
import com.example.demo.management.mapper.CustomerMapper;
import com.example.demo.management.service.CustomerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 货主信息表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Api(tags = "货主相关")
@AccessToken
@CrossOrigin
@RestController
@RequestMapping("/management/customer")
public class CustomerController {

    @Resource
    CustomerService customerService;

    @ApiOperation("货主修改个人信息")
    @PostMapping("/modCustomerInfo")
    public ApiResponse<Object> modCustomerInfo(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody CustomerInfoRequest customerInfoRequest
    ) {
        customerService.modCustomerInfo(customerInfoRequest,loginUser.getLoginId());
        return ApiResponse.success();
    }

    @ApiOperation("获取货主个人信息")
    @PostMapping("/getCustomerInfo")
    public ApiResponse<CustomerInfoResponse> getCustomerInfo(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser
    ) {
        CustomerInfoResponse customerInfoResponse = customerService.getCustomerInfo(loginUser.getLoginId());
        return ApiResponse.success(customerInfoResponse);
    }

    @ApiOperation("获取货主个人信息(id)")
    @PostMapping("/getCustomerInfoById")
    public ApiResponse<CustomerInfoResponse> getCustomerInfo(
            @RequestBody Map<String, Object> mp
    ) {
        String customerId = (String) mp.get("customerId");
        CustomerInfoResponse customerInfoResponse = customerService.getCustomerInfo(customerId);
        return ApiResponse.success(customerInfoResponse);
    }

}

