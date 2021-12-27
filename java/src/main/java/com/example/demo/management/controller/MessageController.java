package com.example.demo.management.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.common.ApiResponse;
import com.example.demo.common.annotation.AccessToken;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.Message;
import com.example.demo.management.entity.request.AddMessageRequest;
import com.example.demo.management.entity.request.AddTradingRecordRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.response.LoginInformationResponse;
import com.example.demo.management.entity.response.SelectMessageResponse;
import com.example.demo.management.entity.response.SelectTradingRecordResponse;
import com.example.demo.management.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;

/**
 * <p>
 * 消息表 前端控制器
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-12-02
 */
@Api(tags = "消息相关")
@AccessToken
@CrossOrigin
@RestController
@RequestMapping("/management/message")
public class MessageController {

    @Resource
    MessageService messageService;

    @PostMapping("/addMessage")
    @ApiOperation(value = "增加消息记录")
    public ApiResponse<Object> addMessage(
            @RequestBody AddMessageRequest addMessageRequest
    ) {
        messageService.addMessage(addMessageRequest);
        return ApiResponse.success();
    }

    @PostMapping("/delMessage")
    @ApiOperation(value = "逻辑删除全部消息记录")
    public ApiResponse<Object> delMessage(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser
    ) {
        messageService.delMessage(loginUser.getLoginId());
        return ApiResponse.success();
    }

    @PostMapping("/delMessageById")
    @ApiOperation(value = "逻辑删除单个消息记录")
    public ApiResponse<Object> delMessageById(
            @RequestBody String messageId
    ) {
        messageService.delMessageById(messageId);
        return ApiResponse.success();
    }

    @PostMapping("/selectMessage")
    @ApiOperation(value = "查看消息记录")
    public ApiResponse<IPage<SelectMessageResponse>> selectMessage(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser,
            @RequestBody PageRequest pageRequest
    ) {
        IPage<SelectMessageResponse> page = messageService.selectMessage(loginUser.getLoginId(),pageRequest);
        return ApiResponse.success(page);
    }

    @PostMapping("/countUnreadMessage")
    @ApiOperation(value = "获取未读消息数")
    public ApiResponse<Integer> countUnreadMessage(
            @ApiIgnore @RequestAttribute(name = "loginUser") LoginUser loginUser
    ) {
        int count = messageService.countUnreadMessage(loginUser.getLoginId());
        return ApiResponse.success(count);
    }
}

