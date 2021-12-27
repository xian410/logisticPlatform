package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.management.entity.GoodsType;
import com.example.demo.management.mapper.GoodsTypeMapper;
import com.example.demo.management.service.GoodsTypeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 货物类型表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class GoodsTypeServiceImpl extends ServiceImpl<GoodsTypeMapper, GoodsType> implements GoodsTypeService {

    @Resource
    GoodsTypeMapper goodsTypeMapper;

    @Override
    public List<GoodsType> getGoodTypes() {
        List<GoodsType> list = new ArrayList<>();
        QueryWrapper<GoodsType> qw = new QueryWrapper<>();
        list = goodsTypeMapper.selectList(qw);
        return list;
    }
}
