package com.example.demo.management.service;

import com.example.demo.management.entity.Driver;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.management.entity.request.ChangePasswordRequest;
import com.example.demo.management.entity.request.CustomerInfoRequest;
import com.example.demo.management.entity.request.DriverInfoRequest;
import com.example.demo.management.entity.response.CustomerInfoResponse;
import com.example.demo.management.entity.response.DriverInfoResponse;

/**
 * <p>
 * 司机信息表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface DriverService extends IService<Driver> {

    /**
     * 修改个人信息
     * @param driverInfoRequest
     * @param driverId
     */
    void modDriverInfo(DriverInfoRequest driverInfoRequest, String driverId);


    /**
     * 获得司机个人信息
     */
    DriverInfoResponse getDriverInfo(String driverId);

}
