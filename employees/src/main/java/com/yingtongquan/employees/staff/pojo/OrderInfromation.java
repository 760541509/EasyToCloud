package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class OrderInfromation implements Serializable {

    private String id;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "订单状态")
    private Integer orderStatus;

    @ApiModelProperty(value = "订单副状态")
    private Integer orderStatusVice;

    @ApiModelProperty(value = "商品总数量")
    private Integer goodsCount;

    @ApiModelProperty(value = "实际支付的金额")
    private Integer orderAmountTotal;

    @ApiModelProperty(value = "备注")
    private String note;

    @ApiModelProperty(value = "收货人姓名")
    private String name;

    @ApiModelProperty(value = "收货人电话")
    private String phone;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "订单生成时间")
    private Long addTime;

    @ApiModelProperty(value = "商品名字（员工查询订单时候使用）",hidden = true)
    private String goodsName;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;

    @ApiModelProperty(value = "会员头像")
    private String headPortrait;

    @ApiModelProperty(value = "订单中的商品信息")
    private List<OrderGoods> orderGoods = new ArrayList<>();

    @ApiModelProperty(value = "已支付的金额")
    private Integer haveToPay;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getOrderAmountTotal() {
        return orderAmountTotal;
    }

    public void setOrderAmountTotal(Integer orderAmountTotal) {
        this.orderAmountTotal = orderAmountTotal;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Integer getHaveToPay() {
        return haveToPay;
    }

    public void setHaveToPay(Integer haveToPay) {
        this.haveToPay = haveToPay;
    }

    @Override
    public String toString() {
        return "OrderInfromation{" +
                "id='" + id + '\'' +
                ", orderNo='" + orderNo + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderStatusVice=" + orderStatusVice +
                ", goodsCount=" + goodsCount +
                ", orderAmountTotal=" + orderAmountTotal +
                ", note='" + note + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", area='" + area + '\'' +
                ", city='" + city + '\'' +
                ", province='" + province + '\'' +
                ", address='" + address + '\'' +
                ", addTime=" + addTime +
                ", goodsName='" + goodsName + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberId=" + memberId +
                ", headPortrait='" + headPortrait + '\'' +
                ", orderGoods=" + orderGoods +
                ", haveToPay=" + haveToPay +
                '}';
    }
}
