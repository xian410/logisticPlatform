package com.example.demo.management.controller;


import com.example.demo.common.ApiResponse;
import com.example.demo.management.entity.GoodsType;
import com.example.demo.management.service.GoodsTypeService;
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
 * 货物类型表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Api(tags = "货物分类相关")
@RestController
@CrossOrigin
@RequestMapping("/management/goods-type")
public class GoodsTypeController {

    @Resource
    GoodsTypeService goodsTypeService;

    @PostMapping("/getGoodTypes")
    @ApiOperation("获取货物所有分类")
    public ApiResponse<List<GoodsType>> getGoodTypes() {
        List<GoodsType> list = goodsTypeService.getGoodTypes();
        return ApiResponse.success(list);
    }
}

