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
@TableName("tbl_order")
@ApiModel(value = "TblOrderPo对象", description = "")
public class TblOrderPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "门店会员id")
    private Integer memberShopId;

    @ApiModelProperty(value = "门店id")
    private Integer shopId;

    @ApiModelProperty(value = "订单状态（0未付款,1已付款,2已发货,3已完成,，4未结清，5取消交易）")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单副状态（0 正常，1 欠货，2 欠款 ,3 欠货&欠款 ）")
    private Integer orderStatusVice;

    @ApiModelProperty(value = "商品总数量")
    private Integer goodsCount;

    @ApiModelProperty(value = "商品总金额")
    private Integer goodsAmountTotal;

    @ApiModelProperty(value = "实际付款金额")
    private Integer orderAmountTotal;

    @ApiModelProperty(value = "运费金额")
    private Integer logisticsFee;

    @ApiModelProperty(value = "订单类型（0普通订单，1积分定，2 团购订单）")
    private Integer orderType;

    @ApiModelProperty(value = "订单渠道（0员工开单，1 用户微信小程序下单")
    private Integer orderChannel;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty("用户ID")
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

    @Override
    public String toString() {
        return "TblOrderPo{" +
                "id=" + id +
                ", orderNo='" + orderNo + '\'' +
                ", memberShopId=" + memberShopId +
                ", shopId=" + shopId +
                ", orderStatus=" + orderStatus +
                ", orderStatusVice=" + orderStatusVice +
                ", goodsCount=" + goodsCount +
                ", goodsAmountTotal=" + goodsAmountTotal +
                ", orderAmountTotal=" + orderAmountTotal +
                ", logisticsFee=" + logisticsFee +
                ", orderType=" + orderType +
                ", orderChannel=" + orderChannel +
                ", addTime=" + addTime +
                ", userId=" + userId +
                '}';
    }
}
