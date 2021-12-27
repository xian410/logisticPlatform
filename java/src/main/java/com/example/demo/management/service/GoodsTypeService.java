package com.example.demo.management.service;

import com.example.demo.management.entity.GoodsType;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 货物类型表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface GoodsTypeService extends IService<GoodsType> {
    List<GoodsType> getGoodTypes();

}
