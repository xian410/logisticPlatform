package com.example.demo.management.entity.response;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Data
@ApiModel(value="查看货物列表响应类")
public class SelectGoodListResponse {

    @ApiModelProperty(value = "货主id")
    private String customerId;

    @ApiModelProperty(value = "货主姓名")
    private String customerName;

    @ApiModelProperty(value = "货主电话")
    private String telephone;

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

    @ApiModelProperty(value = "接单人数")
    private Integer count;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "笔记")
    private String note;

    @ApiModelProperty(value = "创建时间")
    private String createTime;

    @ApiModelProperty(value = "判断是否报价的标志位")
    private Boolean isIntention;
}
