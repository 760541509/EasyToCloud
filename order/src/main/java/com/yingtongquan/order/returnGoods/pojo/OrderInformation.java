package com.yingtongquan.order.returnGoods.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class OrderInformation implements Serializable {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单总金额")
    private Integer orderAmountTotal;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "订单种商品的信息")
    private List<OrderGoodsInformation> orderGoodsInformations = Lists.newArrayList();

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(Integer orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Integer getOrderAmountTotal() {
        return orderAmountTotal;
    }

    public void setOrderAmountTotal(Integer orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<OrderGoodsInformation> getOrderGoodsInformations() {
        return orderGoodsInformations;
    }

    public void setOrderGoodsInformations(List<OrderGoodsInformation> orderGoodsInformations) {
        this.orderGoodsInformations = orderGoodsInformations;
    }
}
