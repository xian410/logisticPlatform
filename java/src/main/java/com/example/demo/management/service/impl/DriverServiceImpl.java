package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.Customer;
import com.example.demo.management.entity.Driver;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.constact.Common;
import com.example.demo.management.entity.enums.GenderEnum;
import com.example.demo.management.entity.request.ChangePasswordRequest;
import com.example.demo.management.entity.request.DriverInfoRequest;
import com.example.demo.management.entity.response.CustomerInfoResponse;
import com.example.demo.management.entity.response.DriverInfoResponse;
import com.example.demo.management.mapper.DriverMapper;
import com.example.demo.management.mapper.LoginUserMapper;
import com.example.demo.management.service.DriverService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 司机信息表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class DriverServiceImpl extends ServiceImpl<DriverMapper, Driver> implements DriverService {

    @Resource
    DriverMapper driverMapper;

    @Resource
    LoginUserMapper loginUserMapper;

    @Override
    public void modDriverInfo(DriverInfoRequest driverInfoRequest, String driverId) {
        Driver driver = driverMapper.selectOne(
                Wrappers.lambdaQuery(Driver.class)
                        .eq(Driver::getDriverId, driverId)
        );
        BeanUtils.copyProperties(driverInfoRequest, driver);

        driverMapper.updateById(driver);
    }


    @Override
    public DriverInfoResponse getDriverInfo(String driverId) {
        Driver driver = driverMapper.selectOne(
                Wrappers.lambdaQuery(Driver.class)
                        .eq(Driver::getDriverId, driverId)
        );
        DriverInfoResponse driverInfoResponse = new DriverInfoResponse();
        BeanUtils.copyProperties(driver,driverInfoResponse);
        driverInfoResponse.setGender(GenderEnum.getMessageByGender(driver.getGender()));
        return driverInfoResponse;
    }
}
