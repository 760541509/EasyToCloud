package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OutboundOrder implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "出库单号")
    private String outboundOrderNo;

    @ApiModelProperty(value = "出库单状态（0 待领单,1 出库中,2 已发货,3 已签收,4取消出库）")
    private Integer outboundOrderStatus;

    @ApiModelProperty(value = "该次发货商品总数量")
    private Integer goodsCount;

    @ApiModelProperty(value = "出库单类型（0订单出货）")
    private Integer outboundOrderType;

    @ApiModelProperty(value = "出库单渠道（ 0系统自动生成，1 员工手动派发订单）")
    private Integer outboundOrderChannel;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOutboundOrderNo() {
        return outboundOrderNo;
    }

    public void setOutboundOrderNo(String outboundOrderNo) {
        this.outboundOrderNo = outboundOrderNo;
    }

    public Integer getOutboundOrderStatus() {
        return outboundOrderStatus;
    }

    public void setOutboundOrderStatus(Integer outboundOrderStatus) {
        this.outboundOrderStatus = outboundOrderStatus;
    }

    public Integer getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(Integer goodsCount) {
        this.goodsCount = goodsCount;
    }

    public Integer getOutboundOrderType() {
        return outboundOrderType;
    }

    public void setOutboundOrderType(Integer outboundOrderType) {
        this.outboundOrderType = outboundOrderType;
    }

    public Integer getOutboundOrderChannel() {
        return outboundOrderChannel;
    }

    public void setOutboundOrderChannel(Integer outboundOrderChannel) {
        this.outboundOrderChannel = outboundOrderChannel;
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

    @Override
    public String toString() {
        return "OutboundOrder{" +
                "id=" + id +
                ", outboundOrderNo='" + outboundOrderNo + '\'' +
                ", outboundOrderStatus=" + outboundOrderStatus +
                ", goodsCount=" + goodsCount +
                ", outboundOrderType=" + outboundOrderType +
                ", outboundOrderChannel=" + outboundOrderChannel +
                ", addTime=" + addTime +
                ", orderNo='" + orderNo + '\'' +
                '}';
    }
}
