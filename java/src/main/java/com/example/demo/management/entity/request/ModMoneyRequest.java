package com.example.demo.management.entity.request;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel("修改账户余额")
public class ModMoneyRequest {

    @ApiModelProperty("loginId")
    private String loginId;

    @ApiModelProperty("money")
    private Float money;
}
