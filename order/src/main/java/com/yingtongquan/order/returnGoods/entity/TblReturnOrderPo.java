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
@TableName("tbl_return_order")
@ApiModel(value = "TblReturnOrderPo对象", description = "")
public class TblReturnOrderPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "退货单号")
    private String returnOrderNo;

    @ApiModelProperty(value = "门店会员id")
    private Integer memberShopId;

    @ApiModelProperty(value = "门店id")
    private Integer shopId;

    @ApiModelProperty(value = "订单状态（0 待处理,1 退货中 ,2已完成,3已拒绝，4取消退货）")
    private Integer returnOrderStatus;

    @ApiModelProperty(value = "商品总数量")
    private Integer goodsCount;

    @ApiModelProperty(value = "商品总金额")
    private Integer goodsAmountTotal;

    @ApiModelProperty(value = "实际退款金额")
    private Integer returnOrderAmountTotal;

    @ApiModelProperty(value = "退款订单类型（0普通退款订单）")
    private Integer returnOrderType;

    @ApiModelProperty(value = "退款订单渠道（0员工退货，1 用户微信小程序退货）")
    private Integer returnOrderChannel;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "退款后第三方返回的退款的单号")
    private String refundId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getReturnOrderNo() {
        return returnOrderNo;
    }

    public void setReturnOrderNo(String returnOrderNo) {
        this.returnOrderNo = returnOrderNo;
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

    public Integer getReturnOrderStatus() {
        return returnOrderStatus;
    }

    public void setReturnOrderStatus(Integer returnOrderStatus) {
        this.returnOrderStatus = returnOrderStatus;
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

    public Integer getReturnOrderAmountTotal() {
        return returnOrderAmountTotal;
    }

    public void setReturnOrderAmountTotal(Integer returnOrderAmountTotal) {
        this.returnOrderAmountTotal = returnOrderAmountTotal;
    }

    public Integer getReturnOrderType() {
        return returnOrderType;
    }

    public void setReturnOrderType(Integer returnOrderType) {
        this.returnOrderType = returnOrderType;
    }

    public Integer getReturnOrderChannel() {
        return returnOrderChannel;
    }

    public void setReturnOrderChannel(Integer returnOrderChannel) {
        this.returnOrderChannel = returnOrderChannel;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getRefundId() {
        return refundId;
    }

    public void setRefundId(String refundId) {
        this.refundId = refundId;
    }

    @Override
    public String toString() {
        return "TblReturnOrderPo{" +
                "id=" + id +
                ", returnOrderNo='" + returnOrderNo + '\'' +
                ", memberShopId=" + memberShopId +
                ", shopId=" + shopId +
                ", returnOrderStatus=" + returnOrderStatus +
                ", goodsCount=" + goodsCount +
                ", goodsAmountTotal=" + goodsAmountTotal +
                ", returnOrderAmountTotal=" + returnOrderAmountTotal +
                ", returnOrderType=" + returnOrderType +
                ", returnOrderChannel=" + returnOrderChannel +
                ", addTime=" + addTime +
                ", orderNo='" + orderNo + '\'' +
                ", refundId='" + refundId + '\'' +
                '}';
    }
}
