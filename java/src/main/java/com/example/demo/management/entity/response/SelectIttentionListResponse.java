package com.example.demo.management.entity.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@ApiModel(value="查看司机意向表响应类")
public class SelectIttentionListResponse {

    @ApiModelProperty(value = "意向货物编号")
    private String intentionId;

    @ApiModelProperty(value = "货主id")
    private String customerId;

    @ApiModelProperty(value = "货主姓名")
    private String customerName;

    @ApiModelProperty(value = "货物编号")
    private String goodId;

    @ApiModelProperty(value = "货物名称")
    private String name;

    @ApiModelProperty(value = "货物类型编号")
    private String typeId;

    @ApiModelProperty(value = "货物类型名称")
    private String typeName;

    @ApiModelProperty(value = "起点")
    private String start;

    @ApiModelProperty(value = "终点")
    private String destination;

    @ApiModelProperty(value = "运费要求-最低")
    private Integer feesMin;

    @ApiModelProperty(value = "运费要求-最高")
    private Integer feesMax;

    @ApiModelProperty(value = "重量")
    private double weight;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "司机姓名")
    private String driverName;

    @ApiModelProperty(value = "司机性别")
    private String gender;

    @ApiModelProperty(value = "司机电话")
    private String telephone;

    @ApiModelProperty(value = "车辆类型编号")
    private String carId;

    @ApiModelProperty(value = "车辆类型名称")
    private String carName;

    @ApiModelProperty(value = "车牌号")
    private String carNumber;

    @ApiModelProperty(value = "运费报价")
    private Float fees;

    @ApiModelProperty(value = "司机备注")
    private String driverRemark;

    @ApiModelProperty(value = "司机有意创建时间")
    private LocalDateTime driverCreateTime;

    @ApiModelProperty(value = "司机有意创建时间")
    private String driverCreateTime1;

    @ApiModelProperty(value = "运单状态")
    private Integer status;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "笔记")
    private String note;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

}
