package com.yingtongquan.order.returnGoods.entity;

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
@TableName("tbl_return_order_goods")
@ApiModel(value = "TblReturnOrderGoodsPo对象", description = "")
public class TblReturnOrderGoodsPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单商品id")
    private Integer orderGoodsId;

    @ApiModelProperty(value = "门店商品单位id")
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "退货的数量（1 . 需大于0   2.订单商品id不为null时，需小于等于购买的数量）")
    private Integer amount;

    @ApiModelProperty(value = "退货单id")
    private Integer returnOrderId;

    @ApiModelProperty(value = "退款的单价")
    private Integer price;

    @ApiModelProperty(value = "购买的单价")
    private Integer buyPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderGoodsId() {
        return orderGoodsId;
    }

    public void setOrderGoodsId(Integer orderGoodsId) {
        this.orderGoodsId = orderGoodsId;
    }

    public Integer getGoodsSkuUnitId() {
        return goodsSkuUnitId;
    }

    public void setGoodsSkuUnitId(Integer goodsSkuUnitId) {
        this.goodsSkuUnitId = goodsSkuUnitId;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(Integer returnOrderId) {
        this.returnOrderId = returnOrderId;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(Integer buyPrice) {
        this.buyPrice = buyPrice;
    }

    @Override
    public String toString() {
        return "TblReturnOrderGoodsPo{" +
                "id=" + id +
                ", orderGoodsId=" + orderGoodsId +
                ", goodsSkuUnitId=" + goodsSkuUnitId +
                ", amount=" + amount +
                ", returnOrderId=" + returnOrderId +
                ", price=" + price +
                ", buyPrice=" + buyPrice +
                "}";
    }
}
