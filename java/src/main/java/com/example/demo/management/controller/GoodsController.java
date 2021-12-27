package com.example.demo.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.Goods;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.request.AddGoodRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.request.SelectGoodsRequest;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import com.example.demo.management.mapper.GoodsMapper;
import com.example.demo.management.service.GoodsService;
import io.swagger.annotations.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.Map;

/**
 * <p>
 * 货物信息表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Api(tags = "货物相关")
@CrossOrigin
@RestController
@AccessToken
@RequestMapping("/management/goods")
public class GoodsController {

    @Resource
    GoodsService goodsService;

    @PostMapping("/addGood")
    @ApiOperation("增加货物")
    public ApiResponse<Object> addGood(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @Validated @RequestBody AddGoodRequest addGoodRequest
            ) {
        goodsService.addGood(addGoodRequest,loginUser.getLoginId());
        return ApiResponse.success();
    }

    @PostMapping("/modGood")
    @ApiOperation("修改货物")
    public ApiResponse<Object> modifyGood(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @Validated @RequestBody AddGoodRequest addGoodRequest
    ) {
        goodsService.modifyGood(addGoodRequest,loginUser.getLoginId());
        return ApiResponse.success();
    }

    @PostMapping("/delGood")
    @ApiOperation("删除货物")
    public ApiResponse<Object> delGood(
            @ApiParam(name = "goodId") @RequestBody Map<String, Object> mp
    ) {
        String goodId = (String) mp.get("goodId");
        try {
            goodsService.deleteGood(goodId);
        }
        catch (CustomException e) {
            return ApiResponse.error(e.getMsg());
        }
        return ApiResponse.success();
    }

    @PostMapping("/delGoodByManager")
    @ApiOperation("删除货物(管理员)")
    public ApiResponse<Object> delGoodByManager(
            @ApiParam(name = "goodId") @RequestBody Map<String, Object> mp
    ) {
        String goodId = (String) mp.get("goodId");
        try {
            goodsService.delGoodByManager(goodId);
        }
        catch (CustomException e) {
            return ApiResponse.error(e.getMsg());
        }
        return ApiResponse.success();
    }

    @PostMapping("/selectAllGoods")
    @ApiOperation("司机查看所有货物")
    public ApiResponse<IPage<SelectGoodListResponse>> selectAllGoods(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
             @RequestBody SelectGoodsRequest selectGoodsRequest
    ) {
        IPage<SelectGoodListResponse> page = goodsService.selectAllGoods(selectGoodsRequest,loginUser.getLoginId());
        return ApiResponse.success(page);
    }

    @PostMapping("/selectAllTrueGoods")
    @ApiOperation("查看所有货物")
    public ApiResponse<IPage<SelectGoodListResponse>> selectAllGoods(
            @RequestBody SelectGoodsRequest selectGoodsRequest
    ) {
        IPage<SelectGoodListResponse> page = goodsService.selectAllTrueGoods(selectGoodsRequest);
        return ApiResponse.success(page);
    }

    @PostMapping("/selectCustomerGoods")
    @ApiOperation("查看自己发布的货物")
    public ApiResponse<IPage<SelectGoodListResponse>> selectCustomerGoods(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
             @RequestBody SelectGoodsRequest selectGoodsRequest
    ) {
        IPage<SelectGoodListResponse> page = goodsService.selectCustomerGoods(selectGoodsRequest,loginUser.getLoginId());
        return ApiResponse.success(page);
    }
}

