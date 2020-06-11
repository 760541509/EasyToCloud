package com.yingtongquan.checkstand.pojo;

import java.io.Serializable;

public class OrderInformation implements Serializable {

    private Integer id;

    //订单号
    private String orderNo;

    //门店会员id
    private Integer memberShopId;

    //门店id
    private Integer shopId;

    //订单状态（0未付款,1已付款,2已发货,3已完成,，4未结清，5取消交易）
    private Integer orderStatus;

    //订单副状态（0 正常，1 欠货，2 欠款 ,3 欠货&欠款 ）
    private Integer orderStatusVice;

    //商品总数量
    private Integer goodsCount;

    //商品总金额
    private Integer goodsAmountTotal;

    //实际付款金额
    private Integer orderAmountTotal;

    //运费金额
    private Integer logisticsFee;

    //订单类型（0普通订单，1积分定，2 团购订单）
    private Integer orderType;

    //订单渠道（0员工开单，1 用户微信小程序下单
    private Integer orderChannel;

    //创建时间
    private Long addTime;

    //用户ID
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getMemberShopId() {
        return memberShopId;
    }

    public void setMemberShopId(Integer memberShopId) {
        this.memberShopId = memberShopId;
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

    public Integer getOrderStatusVice() {
        return orderStatusVice;
    }

    public void setOrderStatusVice(Integer orderStatusVice) {
        this.orderStatusVice = orderStatusVice;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getGoodsAmountTotal() {
        return goodsAmountTotal;
    }

    public void setGoodsAmountTotal(Integer goodsAmountTotal) {
        this.goodsAmountTotal = goodsAmountTotal;
    }

    public Integer getOrderAmountTotal() {
        return orderAmountTotal;
    }

    public void setOrderAmountTotal(Integer orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    public Integer getLogisticsFee() {
        return logisticsFee;
    }

    public void setLogisticsFee(Integer logisticsFee) {
        this.logisticsFee = logisticsFee;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
