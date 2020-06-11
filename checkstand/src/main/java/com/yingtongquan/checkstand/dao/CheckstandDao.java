package com.yingtongquan.checkstand.dao;

import com.yingtongquan.checkstand.pojo.*;

import java.util.List;

public interface CheckstandDao {

    /**
     * @Date 2020/5/16 15:00
     * @Author 胖
     * 根据订单号查询订单详情
     **/
    OrderInformation queryOrder(String orderNo);

    /**
     * @Date 2020/5/16 15:19
     * @Author 胖
     * 通过订单号查询所有的商品
     **/
    List<OrderGoodsInformation> queryOrderAllGoodsInformation(Integer orderId);

    /**
     * @Date 2020/5/16 15:42
     * @Author 胖
     * 添加订单员工表
     **/
    void addOrderThoseResponsible(OrderStaff orderStaff);

    /**
     * @Date 2020/5/16 15:54
     * @Author 胖
     * 修改订单支付状态
     **/
    void updateOrderPaymentStatus(String orderNo);

    /**
     * @Date 2020/5/16 16:39
     * @Author 胖
     * 添加订单交易表
     **/
    void addOrderDeal(OrderDeal orderDeal);

    /**
     * @Date 2020/5/16 17:07
     * @Author 胖
     * 减少库存第一步
     **/
    OrderGoodsQuantity queryGoodsInventory(Integer goodsSkuId);

    /**
     * @Date 2020/5/17 11:33
     * @Author 胖
     *查询商品有多少库存
     **/
    WarehouseGoodsInventory inquireTheRemainingInventoryOfTheGoods(Integer goodsSkuId,Integer warehouseGoodsSpuId);

    /**
     * @Date 2020/5/17 12:01
     * @Author 胖
     *查询规格对应的数量
     **/
    GoodsSpuUnit queryNumber(Integer goodsSkuUnitId);

    /**
     * @Date 2020/5/17 10:20
     * @Author 胖
     *修改商品的库存
     **/
    void updateGoodsInventory(Integer goodsQuantity,Integer goodsSkuId,Integer warehouseGoodsSpuId);

    /**
     * @Date 2020/5/17 12:20
     * @Author 胖
     *修改订单状态
     **/
    void updateOrderGoodsStatus(Integer id,Integer storeAmount);
}
