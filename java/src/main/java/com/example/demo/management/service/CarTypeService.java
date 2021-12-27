package com.example.demo.management.service;

import com.example.demo.management.entity.CarType;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.management.entity.GoodsType;

import java.util.List;

/**
 * <p>
 * 车辆类型表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface CarTypeService extends IService<CarType> {
    List<CarType> getCarTypes();
}
