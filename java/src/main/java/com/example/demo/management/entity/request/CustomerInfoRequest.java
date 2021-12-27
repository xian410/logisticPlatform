package com.example.demo.management.entity.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("货主个人信息请求实体类")
public class CustomerInfoRequest {

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer gender;

    @ApiModelProperty(value = "电话")
    private String telephone;

    @ApiModelProperty(value = "常运货物")
    private String userGoods;

    @ApiModelProperty(value = "住址")
    private String address;
}
