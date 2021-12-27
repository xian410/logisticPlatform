package com.example.demo.management.controller;


import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.request.ChangePasswordRequest;
import com.example.demo.management.entity.request.CustomerInfoRequest;
import com.example.demo.management.entity.request.DriverInfoRequest;
import com.example.demo.management.entity.response.CustomerInfoResponse;
import com.example.demo.management.entity.response.DriverInfoResponse;
import com.example.demo.management.service.CustomerService;
import com.example.demo.management.service.DriverService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 司机信息表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Api(tags = "司机相关")
@AccessToken
@CrossOrigin
@RestController
@RequestMapping("/management/driver")
public class DriverController {
    @Resource
    DriverService driverService;

    @ApiOperation("司机修改个人信息")
    @PostMapping("/modDriverInfo")
    public ApiResponse<Object> modDriverInfo(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody DriverInfoRequest driverInfoRequest
    ) {
        driverService.modDriverInfo(driverInfoRequest,loginUser.getLoginId());
        return ApiResponse.success();
    }


    @ApiOperation("获取司机个人信息")
    @PostMapping("/getDriverInfo")
    public ApiResponse<DriverInfoResponse> getDriverInfo(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser
    ) {
        DriverInfoResponse driverInfoResponse = driverService.getDriverInfo(loginUser.getLoginId());
        return ApiResponse.success(driverInfoResponse);
    }

    @ApiOperation("获取司机个人信息(id)")
    @PostMapping("/getDriverInfoById")
    public ApiResponse<DriverInfoResponse> getDriverInfo(
            @RequestBody Map<String, Object> mp
    ) {
        String driverId = (String) mp.get("driverId");
        DriverInfoResponse driverInfoResponse = driverService.getDriverInfo(driverId);
        return ApiResponse.success(driverInfoResponse);
    }
}

