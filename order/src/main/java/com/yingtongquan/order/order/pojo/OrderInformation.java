package com.yingtongquan.order.order.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class OrderInformation implements Serializable {

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

    @ApiModelProperty(value = "运费")
    private Integer logisticsFee;

    @ApiModelProperty(value = "订单类型（0普通订单，1积分定，2 团购订单）")
    private Integer orderType;

    @ApiModelProperty(value = "订单渠道（0员工开单，1 用户微信小程序下单）")
    private Integer orderChannel;

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

    @ApiModelProperty(value = "省")
    private String provinces;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "店铺名字")
    private String storeName;

    @ApiModelProperty(value = "订单商品信息")
    private List<OrderGoods> orderGoods = Lists.newArrayList();

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "会员头像")
    private String headPortrait;

    @ApiModelProperty(value = "已支付金额")
    private Integer haveToPay;

    private Integer userId;

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Integer getHaveToPay() {
        return haveToPay;
    }

    public void setHaveToPay(Integer haveToPay) {
        this.haveToPay = haveToPay;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "OrderInformation{" +
                "orderNo='" + orderNo + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusVice=" + orderStatusVice +
                ", goodsCount=" + goodsCount +
                ", goodsAmountTotal=" + goodsAmountTotal +
                ", orderAmountTotal=" + orderAmountTotal +
                ", logisticsFee=" + logisticsFee +
                ", orderType=" + orderType +
                ", orderChannel=" + orderChannel +
                ", addTime=" + addTime +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", provinces='" + provinces + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", storeName='" + storeName + '\'' +
                ", orderGoods=" + orderGoods +
                ", memberId=" + memberId +
                ", memberName='" + memberName + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", haveToPay=" + haveToPay +
                ", userId=" + userId +
                '}';
    }
}
