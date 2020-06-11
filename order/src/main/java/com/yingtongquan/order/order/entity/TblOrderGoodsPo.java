package com.yingtongquan.order.order.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@TableName("tbl_order_goods")
@ApiModel(value = "TblOrderGoodsPo对象", description = "")
public class TblOrderGoodsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单的id")
    private Integer orderId;

    @ApiModelProperty(value = "订单商品名称")
    private String orderGoodsName;

    @ApiModelProperty(value = "商品图")
    private String image;

    @ApiModelProperty(value = "门店商品id")
    private Integer shopGoodsId;

    @ApiModelProperty(value = "共用商品单位id")
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "共用商品sku的id")
    private Integer goodsSkuId;

    @ApiModelProperty(value = "购买的单价")
    private Integer price;

    @ApiModelProperty(value = "商品的原单价")
    private Integer originalPrice;

    @ApiModelProperty(value = "分摊的优惠券价格（用于计算出库员提成）")
    private Integer shareCouponsPrice;

    @ApiModelProperty(value = "购买的数量")
    private Integer amount;

    @ApiModelProperty(value = "员工佣金百分比（按销售价格）")
    private Integer staffCommissionRate;

    @ApiModelProperty(value = "分销商佣金百分比（按销售价格）")
    private Integer distributorCommissionRate;

    @ApiModelProperty(value = "实际发货数量（可为负数）")
    private Integer storeAmount;

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

    public Integer getStoreAmount() {
        return storeAmount;
    }

    public void setStoreAmount(Integer storeAmount) {
        this.storeAmount = storeAmount;
    }

    @Override
    public String toString() {
        return "TblOrderGoodsPo{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", orderGoodsName='" + orderGoodsName + '\'' +
                ", image='" + image + '\'' +
                ", shopGoodsId=" + shopGoodsId +
                ", goodsSkuUnitId=" + goodsSkuUnitId +
                ", goodsSkuId=" + goodsSkuId +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", shareCouponsPrice=" + shareCouponsPrice +
                ", amount=" + amount +
                ", staffCommissionRate=" + staffCommissionRate +
                ", distributorCommissionRate=" + distributorCommissionRate +
                ", storeAmount=" + storeAmount +
                '}';
    }
}
