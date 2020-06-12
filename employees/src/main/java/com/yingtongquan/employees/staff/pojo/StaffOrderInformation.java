package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StaffOrderInformation implements Serializable {

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "订单状态")
    private Integer status;

    @ApiModelProperty(value = "订单副状态")
    private Integer statusVice;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "收货地址")
    private String address;

    @ApiModelProperty(value = "收货人姓名")
    private String consignee;

    @ApiModelProperty(value = "收货人电话")
    private String phone;

    @ApiModelProperty(value = "是否自提")
    private Integer isSince;

    @ApiModelProperty(value = "订单备注")
    private String note;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "会员头像")
    private String headPortrait;

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "门店头像")
    private String storeHeadPortrait;

    @ApiModelProperty(value = "商品总数量")
    private Integer amountGoods;

    @ApiModelProperty(value = "商品总价")
    private Integer goodsTotalPrice;

    @ApiModelProperty(value = "订单实际支付金额")
    private Integer orderPrice;

    @ApiModelProperty(value = "已支付金额")
    private Integer amountPaid;

    @ApiModelProperty(value = "订单商品")
    private List<StaffOrderGoods> staffOrderGoods = new ArrayList<>();

    @ApiModelProperty(value = "订单支付明细")
    private List<StaffOrderPayment> staffOrderPayments = new ArrayList<>();

    @ApiModelProperty(value = "出库单详细")
    private List<StaffOutboundOrder> staffOutboundOrders = new ArrayList<>();

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatusVice() {
        return statusVice;
    }

    public void setStatusVice(Integer statusVice) {
        this.statusVice = statusVice;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getConsignee() {
        return consignee;
    }

    public void setConsignee(String consignee) {
        this.consignee = consignee;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getIsSince() {
        return isSince;
    }

    public void setIsSince(Integer isSince) {
        this.isSince = isSince;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreHeadPortrait() {
        return storeHeadPortrait;
    }

    public void setStoreHeadPortrait(String storeHeadPortrait) {
        this.storeHeadPortrait = storeHeadPortrait;
    }

    public Integer getAmountGoods() {
        return amountGoods;
    }

    public void setAmountGoods(Integer amountGoods) {
        this.amountGoods = amountGoods;
    }

    public Integer getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(Integer goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public Integer getOrderPrice() {
        return orderPrice;
    }

    public void setOrderPrice(Integer orderPrice) {
        this.orderPrice = orderPrice;
    }

    public Integer getAmountPaid() {
        return amountPaid;
    }

    public void setAmountPaid(Integer amountPaid) {
        this.amountPaid = amountPaid;
    }

    public List<StaffOrderGoods> getStaffOrderGoods() {
        return staffOrderGoods;
    }

    public void setStaffOrderGoods(List<StaffOrderGoods> staffOrderGoods) {
        this.staffOrderGoods = staffOrderGoods;
    }

    public List<StaffOrderPayment> getStaffOrderPayments() {
        return staffOrderPayments;
    }

    public void setStaffOrderPayments(List<StaffOrderPayment> staffOrderPayments) {
        this.staffOrderPayments = staffOrderPayments;
    }

    public List<StaffOutboundOrder> getStaffOutboundOrders() {
        return staffOutboundOrders;
    }

    public void setStaffOutboundOrders(List<StaffOutboundOrder> staffOutboundOrders) {
        this.staffOutboundOrders = staffOutboundOrders;
    }

    @Override
    public String toString() {
        return "StaffOrderInformation{" +
                "orderNo='" + orderNo + '\'' +
                ", status=" + status +
                ", statusVice=" + statusVice +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phone='" + phone + '\'' +
                ", isSince=" + isSince +
                ", note='" + note + '\'' +
                ", memberName='" + memberName + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", memberId=" + memberId +
                ", storeName='" + storeName + '\'' +
                ", storeHeadPortrait='" + storeHeadPortrait + '\'' +
                ", amountGoods=" + amountGoods +
                ", goodsTotalPrice=" + goodsTotalPrice +
                ", orderPrice=" + orderPrice +
                ", amountPaid=" + amountPaid +
                ", staffOrderGoods=" + staffOrderGoods +
                ", staffOrderPayments=" + staffOrderPayments +
                ", staffOutboundOrders=" + staffOutboundOrders +
                '}';
    }
}
