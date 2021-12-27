package com.example.demo.management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.management.entity.Goods;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.management.entity.LoginUser;
import com.example.demo.management.entity.request.AddGoodRequest;
import com.example.demo.management.entity.request.PageRequest;
import com.example.demo.management.entity.request.SelectGoodsRequest;
import com.example.demo.management.entity.response.SelectGoodListResponse;

/**
 * <p>
 * 货物信息表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface GoodsService extends IService<Goods> {
    /**
     * 添加货物
     * @param goods 货物表单
     */
    void addGood(AddGoodRequest addGoodRequest, String loginId);

    /**
     * 修改货物
     * @param good
     */
    void modifyGood(AddGoodRequest addGoodRequest, String loginId);

    /**
     * 删除货物
     * @param goodId
     */
    void deleteGood(String goodId);

    /**
     * 司机查看所有货物
     */
    IPage<SelectGoodListResponse> selectAllGoods(SelectGoodsRequest selectGoodsRequest, String driverId);


    /**
     * 货主查看自己发布的货物
     */
    IPage<SelectGoodListResponse> selectCustomerGoods(SelectGoodsRequest selectGoodsRequest,String customerId);

    /**
     * 管理员查看所有货物
     * @param selectGoodsRequest
     * @return
     */
    IPage<SelectGoodListResponse> selectAllTrueGoods(SelectGoodsRequest selectGoodsRequest);

    /**
     * 管理员删除货物
     * @param goodId
     */
    void delGoodByManager(String goodId);
}
