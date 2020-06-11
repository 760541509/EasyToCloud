package com.yingtongquan.customer.order.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "订单状态（0未付款,1已付款,2已发货,3已完成,4未结清,5取消交易）")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单副状态（0 正常,1 欠货,2 欠款,3 欠货&欠款 ）")
    private Integer orderStatusVice;

    @ApiModelProperty(value = "商品总数量")
    private Integer goodsCount;

    @ApiModelProperty(value = "商品总金额")
    private Integer goodsAmountTotal;

    @ApiModelProperty(value = "实际付款金额")
    private Integer orderAmountTotal;

    @ApiModelProperty(value = "订单生成时间")
    private Long addTime;

    @ApiModelProperty(value = "订单收货人电话")
    private String phone;

    @ApiModelProperty(value = "订单收货人姓名")
    private String name;

    @ApiModelProperty(value = "订单收货地址中的省市区编号")
    private Integer areaId;

    @ApiModelProperty(value = "订单收货地址的详细地址")
    private String address;

    @ApiModelProperty(value = "省市区")
    private String provinces;

    @ApiModelProperty(value = "店铺名字")
    private String storeName;

    @ApiModelProperty(value = "优惠多少钱")
    private Integer reduce;

    @ApiModelProperty(value = "打多少折")
    private Integer discount;

    @ApiModelProperty(value = "订单中的商品信息")
    private List<OrderGoods> orderGoods = Lists.newArrayList();

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
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

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProvinces() {
        return provinces;
    }

    public void setProvinces(String provinces) {
        this.provinces = provinces;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Integer getReduce() {
        return reduce;
    }

    public void setReduce(Integer reduce) {
        this.reduce = reduce;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNo='" + orderNo + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusVice=" + orderStatusVice +
                ", goodsCount=" + goodsCount +
                ", goodsAmountTotal=" + goodsAmountTotal +
                ", orderAmountTotal=" + orderAmountTotal +
                ", addTime=" + addTime +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", provinces='" + provinces + '\'' +
                ", storeName='" + storeName + '\'' +
                ", reduce=" + reduce +
                ", discount=" + discount +
                ", orderGoods=" + orderGoods +
                '}';
    }
}
