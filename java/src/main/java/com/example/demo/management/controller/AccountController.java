package com.example.demo.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.request.GetAccountRequest;
import com.example.demo.management.entity.request.LoginRequest;
import com.example.demo.management.entity.request.ModMoneyRequest;
import com.example.demo.management.entity.response.AllAccountResponse;
import com.example.demo.management.entity.response.LoginInformationResponse;
import com.example.demo.management.service.AccountService;
import com.example.demo.management.service.TradingRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import java.awt.geom.FlatteningPathIterator;
import java.util.Map;

/**
 * <p>
 * 账户信息表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@AccessToken
@Api(tags = "账户相关")
@CrossOrigin
@RestController
@RequestMapping("/management/account")
public class AccountController {
    @Resource
    AccountService accountService;

    @Resource
    TradingRecordService tradingRecordService;

    @PostMapping("/getAllAccount")
    @ApiOperation(value = "查看所有账号")
    public ApiResponse<IPage<AllAccountResponse>> getAll(
            @RequestBody GetAccountRequest getAccountRequest
            ) {
        IPage<AllAccountResponse> allAccountResponse = accountService.queryAll(getAccountRequest);
        return ApiResponse.success(allAccountResponse);
    }

    @PostMapping("/queryMoney")
    @ApiOperation(value = "查询账户金额")
    public ApiResponse<Float> queryMoney(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser
    ) {
        Float money = accountService.queryMoney(loginUser.getLoginId());
        return ApiResponse.success(money);
    }

    @PostMapping("/modMoney")
    @ApiOperation(value = "修改账户金额")
    public ApiResponse<Float> modMoney(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody Float money
    ) {
        accountService.modMoney(loginUser.getLoginId(),money);
        return ApiResponse.success();
    }

    @PostMapping("/modMoneyById")
    @ApiOperation(value = "修改账户金额ById")
    public ApiResponse<Float> modMoney(
            @RequestBody ModMoneyRequest modMoneyRequest
    ) {
        accountService.modMoneyById(modMoneyRequest.getLoginId(),modMoneyRequest.getMoney());
        return ApiResponse.success();
    }

    @PostMapping("/addMoney")
    @ApiOperation(value = "充值金额")
    public ApiResponse<Float> addMoney(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody Float money
    ) {
        accountService.addMoney(loginUser.getLoginId(),money);
        return ApiResponse.success();
    }

}

