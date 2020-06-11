package com.yingtongquan.checkstand.pojo;

import java.io.Serializable;

public class OrderGoodsInformation implements Serializable {

    private Integer id;

    //订单的id
    private Integer orderId;

    //订单商品名称
    private String orderGoodsName;

    //商品图
    private String image;

    //门店商品id
    private Integer shopGoodsId;

    //共用商品单位id
    private Integer goodsSkuUnitId;

    //共用商品sku的id
    private Integer goodsSkuId;

    //购买的单价
    private Integer price;

    //商品的原单价
    private Integer originalPrice;

    //分摊的优惠券价格（用于计算出库员提成）
    private Integer shareCouponsPrice;

    //购买的数量
    private Integer amount;

    //员工佣金百分比（按销售价格）
    private Integer staffCommissionRate;

    //分销商佣金百分比（按销售价格）
    private Integer distributorCommissionRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderGoodsName() {
        return orderGoodsName;
    }

    public void setOrderGoodsName(String orderGoodsName) {
        this.orderGoodsName = orderGoodsName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getShopGoodsId() {
        return shopGoodsId;
    }

    public void setShopGoodsId(Integer shopGoodsId) {
        this.shopGoodsId = shopGoodsId;
    }

    public Integer getGoodsSkuUnitId() {
        return goodsSkuUnitId;
    }

    public void setGoodsSkuUnitId(Integer goodsSkuUnitId) {
        this.goodsSkuUnitId = goodsSkuUnitId;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getShareCouponsPrice() {
        return shareCouponsPrice;
    }

    public void setShareCouponsPrice(Integer shareCouponsPrice) {
        this.shareCouponsPrice = shareCouponsPrice;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getStaffCommissionRate() {
        return staffCommissionRate;
    }

    public void setStaffCommissionRate(Integer staffCommissionRate) {
        this.staffCommissionRate = staffCommissionRate;
    }

    public Integer getDistributorCommissionRate() {
        return distributorCommissionRate;
    }

    public void setDistributorCommissionRate(Integer distributorCommissionRate) {
        this.distributorCommissionRate = distributorCommissionRate;
    }
}
