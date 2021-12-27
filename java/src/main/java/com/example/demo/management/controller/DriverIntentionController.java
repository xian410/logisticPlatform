package com.example.demo.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.request.AddDriverIntentionRequest;
import com.example.demo.management.entity.request.SelectGoodsRequest;
import com.example.demo.management.entity.request.SelectIntentionRequest;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import com.example.demo.management.entity.response.SelectIttentionListResponse;
import com.example.demo.management.service.DriverIntentionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 司机意向表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@CrossOrigin
@RestController
@AccessToken
@Api(tags = "司机有意表相关")
@RequestMapping("/management/driver-intention")
public class DriverIntentionController {
    @Resource
    DriverIntentionService driverIntentionService;

    @ApiOperation("添加司机有意货物")
    @PostMapping("/addIntention")
    public ApiResponse<Object> addIntention(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @Validated @RequestBody AddDriverIntentionRequest addDriverIntentionRequest
            ) {
        driverIntentionService.addIntention(addDriverIntentionRequest,loginUser.getLoginId());
        return ApiResponse.success();
    }

    @PostMapping("/deleteIntention")
    @ApiOperation("司机删除意向")
    public ApiResponse<Object> deleteIntention(
            @ApiParam(name = "intentionId") @RequestBody Map<String, Object> mp
    ) {
        String intentionId = (String) mp.get("intentionId");
        try{
            driverIntentionService.deleteIntention(intentionId);
        }catch (CustomException e) {
            return ApiResponse.error(e.getMsg());
        }
        return ApiResponse.success();
    }

    @PostMapping("/selectDriverIntention")
    @ApiOperation("司机查看自己意向表")
    public ApiResponse<IPage<SelectIttentionListResponse>> selectDriverIntention(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody SelectIntentionRequest selectIntentionRequest
    ) {
        IPage<SelectIttentionListResponse> page = driverIntentionService.selectDriverIntention(selectIntentionRequest, loginUser.getLoginId());
        return ApiResponse.success(page);
    }

    @PostMapping("/selectCustomerIntention")
    @ApiOperation("货主查看意向表")
    public ApiResponse<IPage<SelectIttentionListResponse>> selectCustomerIntention(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody SelectIntentionRequest selectIntentionRequest
    ) {
        IPage<SelectIttentionListResponse> page = driverIntentionService.selectCustomerIntention(selectIntentionRequest, loginUser.getLoginId());
        return ApiResponse.success(page);
    }
}

