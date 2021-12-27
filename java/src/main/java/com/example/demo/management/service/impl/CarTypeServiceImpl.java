package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.management.entity.CarType;
import com.example.demo.management.entity.GoodsType;
import com.example.demo.management.mapper.CarTypeMapper;
import com.example.demo.management.service.CarTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 车辆类型表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class CarTypeServiceImpl extends ServiceImpl<CarTypeMapper, CarType> implements CarTypeService {

    @Resource
    CarTypeMapper carTypeMapper;

    @Override
    public List<CarType> getCarTypes() {
        List<CarType> list = new ArrayList<>();
        QueryWrapper<CarType> qw = new QueryWrapper<>();
        list = carTypeMapper.selectList(qw);
        return list;
    }
}
