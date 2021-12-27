package com.example.demo.management.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.exception.CustomException;
import com.example.demo.management.entity.DriverIntention;
import com.example.demo.management.entity.Goods;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.Orders;
import com.example.demo.management.entity.constact.Prefix;
import com.example.demo.management.entity.enums.GenderEnum;
import com.example.demo.management.entity.request.AddGoodRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.request.SelectGoodsRequest;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import com.example.demo.management.entity.response.SelectIttentionListResponse;
import com.example.demo.management.mapper.*;
import com.example.demo.management.service.GoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * <p>
 * 货物信息表 服务实现类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Resource
    GoodsMapper goodsMapper;

    @Resource
    CustomerMapper customerMapper;

    @Resource
    GoodsTypeMapper goodsTypeMapper;

    @Resource
    DriverIntentionMapper driverIntentionMapper;

    @Resource
    OrdersMapper ordersMapper;

    @Override
    public void addGood(AddGoodRequest addGoodRequest, String loginId) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(addGoodRequest,goods);
        goods.setCustomerId(loginId);
        goods.setGoodId(Prefix.GOOD_PREFIX + UUID.randomUUID());

        goodsMapper.insert(goods);
    }

    @Override
    public void modifyGood(AddGoodRequest addGoodRequest, String loginId) {
        Goods goods = new Goods();
        BeanUtils.copyProperties(addGoodRequest,goods);
        goodsMapper.update(goods,Wrappers.lambdaUpdate(Goods.class)
                            .eq(Goods::getGoodId, goods.getGoodId()));
    }

    @Override
    public void deleteGood(String goodId) {
        Goods goods = goodsMapper.selectOne(Wrappers.lambdaQuery(Goods.class)
                .eq(Goods::getGoodId, goodId));
        if (goods == null) {
            throw new CustomException("该货物不存在");
        }

        QueryWrapper<Orders> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("good_id", goodId);
        List<Orders> orders = ordersMapper.selectList(queryWrapper);
        if (orders.size() != 0) {
            throw new CustomException("货物正在运输中，不可删除");
        }

        goodsMapper.delete(Wrappers.lambdaQuery(Goods.class)
                .eq(Goods::getGoodId,goodId));
    }


    @Override
    public IPage<SelectGoodListResponse> selectAllGoods(SelectGoodsRequest selectGoodsRequest,String driverId) {

        IPage<SelectGoodListResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectGoodsRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectGoodsRequest.getPageRequest().getSize());


        IPage<SelectGoodListResponse> page  = goodsMapper.selectAllGoods(queryPageRequest, selectGoodsRequest);

        List<SelectGoodListResponse> list = page.getRecords();

        int len = list.size();
        for (int i = 0; i < len; i++) {
            String goodId = list.get(i).getGoodId();
            DriverIntention driverIntention = driverIntentionMapper.selectOne(Wrappers.lambdaQuery(DriverIntention.class)
                    .eq(DriverIntention::getDriverId, driverId)
                    .eq(DriverIntention::getGoodId, goodId));
            List<DriverIntention> driverIntentions = driverIntentionMapper.selectList(Wrappers.lambdaQuery(DriverIntention.class).eq(DriverIntention::getGoodId, goodId));
            list.get(i).setCount(driverIntentions.size());
            if (driverIntention != null) {
                list.get(i).setIsIntention(true);
            } else {
                list.get(i).setIsIntention(false);
            }
        }
        return page;
    }

    @Override
    public IPage<SelectGoodListResponse> selectCustomerGoods(SelectGoodsRequest selectGoodsRequest,String customerId) {

        IPage<SelectGoodListResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectGoodsRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectGoodsRequest.getPageRequest().getSize());


        IPage<SelectGoodListResponse> page  = goodsMapper.selectCustomerGoods(queryPageRequest, selectGoodsRequest,customerId);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        List<SelectGoodListResponse> list = page.getRecords();
        for(int i = 0; i < list.size(); i++) {
            String goodId = list.get(i).getGoodId();
            List<DriverIntention> driverIntentions = driverIntentionMapper.selectList(new QueryWrapper<DriverIntention>().eq("good_id", goodId));
            list.get(i).setCount(driverIntentions.size());
        }
        page.setRecords(list);
        return page;

    }

    @Override
    public IPage<SelectGoodListResponse> selectAllTrueGoods(SelectGoodsRequest selectGoodsRequest) {
        IPage<SelectGoodListResponse> queryPageRequest = new Page<>();
        queryPageRequest.setCurrent(selectGoodsRequest.getPageRequest().getCurrent());
        queryPageRequest.setSize(selectGoodsRequest.getPageRequest().getSize());

        IPage<SelectGoodListResponse> page  = goodsMapper.selectAllGoods(queryPageRequest, selectGoodsRequest);

        return page;
    }

    @Override
    public void delGoodByManager(String goodId) {
        Goods goods = goodsMapper.selectOne(Wrappers.lambdaQuery(Goods.class)
                .eq(Goods::getGoodId, goodId));
        if (goods == null) {
            throw new CustomException("该货物不存在");
        }
        goodsMapper.delete(Wrappers.lambdaQuery(Goods.class)
                .eq(Goods::getGoodId,goodId));
    }
}
