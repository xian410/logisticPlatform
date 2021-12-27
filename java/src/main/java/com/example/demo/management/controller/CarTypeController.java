package com.example.demo.management.controller;


import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.management.entity.CarType;
import com.example.demo.management.entity.GoodsType;
import com.example.demo.management.service.CarTypeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 车辆类型表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Api(tags = "车辆分类相关")
@CrossOrigin
@AccessToken
@RestController
@RequestMapping("/management/car-type")
public class CarTypeController {

    @Resource
    CarTypeService carTypeService;

    @PostMapping("/getCarTypes")
    @ApiOperation("获取车辆所有分类")
    public ApiResponse<List<CarType>> getCarTypes() {
        List<CarType> list = carTypeService.getCarTypes();
        return ApiResponse.success(list);
    }
}

