package com.example.demo.management.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("司机个人信息请求实体类")
public class DriverInfoRequest {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "车辆类型编号")
    private String carId;

    @ApiModelProperty(value = "车牌号")
    private String carNumber;

    @ApiModelProperty(value = "运输类型")
    private String transType;
}
