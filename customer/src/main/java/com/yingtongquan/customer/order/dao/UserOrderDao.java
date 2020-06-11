package com.yingtongquan.customer.order.dao;

import com.yingtongquan.customer.order.pojo.Order;

import java.util.List;

public interface UserOrderDao {

    /**
     * @Date 2020/6/1 16:16
     * @Author 胖
     * 通过微信ID查询出用户表中存在的ID
     **/
    Integer queryUserId(Integer WXId);

    /**
     * @Date 2020/6/8 16:06
     * @Author 胖
     * 查询所有的订单
     **/
    List<Order> queryUserAllOrder(Integer userId);
}
