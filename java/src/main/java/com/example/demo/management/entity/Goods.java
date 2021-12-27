package com.example.demo.management.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 货物信息表
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Goods对象", description="货物信息表")
public class Goods implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "货主id")
    private String customerId;

    @ApiModelProperty(value = "货物编号")
    private String goodId;

    @ApiModelProperty(value = "货物名称")
    private String name;

    @ApiModelProperty(value = "货物类型编号")
    private String typeId;

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

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "笔记")
    private String note;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
