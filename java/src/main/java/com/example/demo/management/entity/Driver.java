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
 * 司机信息表
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="Driver对象", description="司机信息表")
public class Driver implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "自增主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "用户主键")
    private String loginId;

    @ApiModelProperty(value = "司机id")
    private String driverId;

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

    @ApiModelProperty(value = "是否删除")
    private Boolean isDelete;

    @ApiModelProperty(value = "笔记")
    private String note;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
