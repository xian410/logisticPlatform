package com.example.demo.management.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.management.entity.Goods;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.request.SelectGoodsRequest;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 货物信息表 Mapper 接口
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface GoodsMapper extends BaseMapper<Goods> {

    /**
     * 获取货物名字
     * @param goodId
     * @return
     */
    String getGoodName(@Param("goodId") String goodId);

    /**
     * 司机查看所有货物
     */
    IPage<SelectGoodListResponse> selectAllGoods(IPage<SelectGoodListResponse> queryPageRequest,
                                                 @Param("selectGoodsRequest") SelectGoodsRequest selectGoodsRequest);

    /**
     * 货主查看自己的货物
     */
    IPage<SelectGoodListResponse> selectCustomerGoods(IPage<SelectGoodListResponse> queryPageRequest,
                                                 @Param("selectGoodsRequest") SelectGoodsRequest selectGoodsRequest,
                                                 @Param("customerId") String customerId);

}
