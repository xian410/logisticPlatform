package com.example.demo.management.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.demo.management.entity.Orders;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.management.entity.request.AddGoodRequest;
import com.example.demo.management.entity.request.AddOrderRequest;
import com.example.demo.management.entity.request.SelectGoodsRequest;
import com.example.demo.management.entity.request.SelectOrdersRequest;
import com.example.demo.management.entity.response.SelectGoodListResponse;
import com.example.demo.management.entity.response.SelectOrdersResponse;

/**
 * <p>
 * 订单信息表 服务类
 * </p>
 *
 * @author LiuJingxian
 * @since 2021-11-15
 */
public interface OrdersService extends IService<Orders> {
    /**
     * 添加订单
     * @param goods
     */
    void addOrders(AddOrderRequest addOrderRequest, String loginId);


    /**i
     * 查看货物是否已经生成订单
     * @param goods
     */
    void checkOrders(String good_id);


    /**
     * 修改订单
     * @param good
     */
    void modifyOrders(AddOrderRequest addOrderRequest, String loginId);

    /**
     * 删除订单
     * @param orderId
     */
    void deleteOrders(String orderId);

    /**
     * 司机查看自己的订单
     */
    IPage<SelectOrdersResponse> selectDriverOrders(SelectOrdersRequest selectOrdersRequest,String driverId);

    /**
     * 货主查看自己的订单
     */
    IPage<SelectOrdersResponse> selectCustomerOrders(SelectOrdersRequest selectOrdersRequest, String customerId);

    /**
     * 管理员查看全部订单
     * @param selectOrdersRequest
     * @return
     */
    IPage<SelectOrdersResponse> selectAllOrders(SelectOrdersRequest selectOrdersRequest);
}
