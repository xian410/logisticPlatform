package com.example.demo.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 订单信息表
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Orders对象", description="订单信息表")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单编号")
    private String orderId;

    @ApiModelProperty(value = "货物编号")
    private String goodId;

    @ApiModelProperty(value = "意向货物编号")
    private String intentionId;

    @ApiModelProperty(value = "货主id")
    private String customerId;

    @ApiModelProperty(value = "司机id")
    private String driverId;

    @ApiModelProperty(value = "运费报价")
    private Float fees;

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "笔记")
    private String note;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
