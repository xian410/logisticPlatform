package com.example.demo.management.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@ApiModel("增加货物请求实体类")
public class AddGoodRequest {

    @ApiModelProperty(value = "货物id")
    private String goodId;

    @ApiModelProperty(value = "货主id")
    private String customerId;

    @ApiModelProperty(value = "货物名称")
    @NotBlank(message = "货物名称不能为空")
    private String name;

    @NotBlank(message = "货物类型编号不能为空")
    @ApiModelProperty(value = "货物类型编号")
    private String typeId;

    @NotBlank(message = "起点不能为空")
    @ApiModelProperty(value = "起点")
    private String start;

    @NotBlank(message = "终点不能为空")
    @ApiModelProperty(value = "终点")
    private String destination;

    @ApiModelProperty(value = "运费要求-最低")
    private Integer feesMin;

    @ApiModelProperty(value = "运费要求-最高")
    private Integer feesMax;

    @ApiModelProperty(value = "重量")
    private double weight;

    @ApiModelProperty(value = "备注")
    private String remark;
}
