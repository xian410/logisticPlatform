package com.example.demo.management.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;


@Data
@ApiModel("获取货主信息实体类")
public class CustomerInfoResponse {
    @ApiModelProperty(value = "用户主键")
    private String loginId;

    @ApiModelProperty(value = "货主id")
    private String customerId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private String gender;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "常运货物")
    private String userGoods;

    @ApiModelProperty(value = "住址")
    private String address;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "笔记")
    private String note;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;
}
