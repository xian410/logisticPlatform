package com.example.demo.management.entity.request;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Api("增加订单实体类")
public class AddOrderRequest {
    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "货物编号")
    private String goodId;

    @ApiModelProperty(value = "意向货物编号")
    private String intentionId;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "运费报价")
    private Float fees;

    @ApiModelProperty(value = "状态")
    private Integer status;
}
