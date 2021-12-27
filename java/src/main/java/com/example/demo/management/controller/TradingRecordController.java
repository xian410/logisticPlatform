package com.example.demo.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.request.AddTradingRecordRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.response.LoginInformationResponse;
import com.example.demo.management.entity.response.SelectTradingRecordResponse;
import com.example.demo.management.service.TradingRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.util.Map;

/**
 * <p>
 * 交易记录表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Api(tags = "交易记录相关")
@AccessToken
@CrossOrigin
@RestController
@RequestMapping("/management/trading-record")
public class TradingRecordController {

    @Resource
    TradingRecordService tradingRecordService;

    @PostMapping("/addRecord")
    @ApiOperation(value = "增加交易记录")
    public ApiResponse<LoginInformationResponse> addRecord(
            @RequestBody AddTradingRecordRequest addTradingRecordRequest
    ) {
        tradingRecordService.addRecord(addTradingRecordRequest);
        return ApiResponse.success();
    }

    @PostMapping("/selectTradingRecord")
    @ApiOperation(value = "查看交易记录")
    public ApiResponse<IPage<SelectTradingRecordResponse>> selectTradingRecord(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody PageRequest pageRequest
    ) {
        IPage<SelectTradingRecordResponse> page = tradingRecordService.selectTradingRecord(loginUser.getLoginId(),pageRequest);
        return ApiResponse.success(page);
    }

    @PostMapping("/selectAllTradingRecord")
    @ApiOperation(value = "查看全部交易记录")
    public ApiResponse<IPage<SelectTradingRecordResponse>> selectTradingRecord(
            @RequestBody PageRequest pageRequest
    ) {
        IPage<SelectTradingRecordResponse> page = tradingRecordService.selectAllTradingRecord(pageRequest);
        return ApiResponse.success(page);
    }

    @PostMapping("/delTradingRecord")
    @ApiOperation(value = "删除交易记录")
    public ApiResponse<Object> delTradingRecord(
            @ApiParam("tradeId") @RequestBody Map<String, Object> mp
    ) {
        String tradeId = (String) mp.get("tradeId");
        tradingRecordService.delTrade(tradeId);
        return ApiResponse.success();
    }



}

