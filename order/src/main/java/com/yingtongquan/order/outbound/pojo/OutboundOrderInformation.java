package com.yingtongquan.order.outbound.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class OutboundOrderInformation implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "出库单号")
    private String outboundOrderNo;

    @ApiModelProperty(value = "出库单状态")
    private Integer outboundOrderStatus;

    @ApiModelProperty(value = "该次发货商品总数量")
    private Integer goodsCount;

    @ApiModelProperty(value = "出库单渠道（0系统自动生成，1 员工手动派发订单）")
    private Integer outboundOrderChannel;

    @ApiModelProperty(value = "出库时间")
    private Integer addTime;

    @ApiModelProperty(value = "订单号")
    private String orderNo;

    @ApiModelProperty(value = "门店会员编号")
    private Integer memberShopId;

    @ApiModelProperty(value = "收货人电话")
    private String phone;

    @ApiModelProperty(value = "收货人姓名")
    private String name;

    @ApiModelProperty(value = "收货地区编号")
    private Integer areaId;

    @ApiModelProperty(value = "收货地址详细")
    private String address;

    @ApiModelProperty(value = "是否自提（0 自提，1 物流）")
    private Integer isSince;

    @ApiModelProperty(value = "物流公司名称")
    private String logisticsName;

    @ApiModelProperty(value = "物流单号")
    private String logisticsNo;

    @ApiModelProperty(value = "出库员工ID")
    private Integer staffId;

    @ApiModelProperty(value = "员工的提成金额")
    private Integer commissionAmount;

    @ApiModelProperty(value = "出库完成时间")
    private Long staffAddTime;

    @ApiModelProperty(value = "出库单中的商品数量")
    private List<OutboundOrderGoods> outboundOrderGoods = Lists.newArrayList();

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

    public Integer getOutboundOrderChannel() {
        return outboundOrderChannel;
    }

    public void setOutboundOrderChannel(Integer outboundOrderChannel) {
        this.outboundOrderChannel = outboundOrderChannel;
    }

    public Integer getAddTime() {
        return addTime;
    }

    public void setAddTime(Integer addTime) {
        this.addTime = addTime;
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

    public Integer getIsSince() {
        return isSince;
    }

    public void setIsSince(Integer isSince) {
        this.isSince = isSince;
    }

    public String getLogisticsName() {
        return logisticsName;
    }

    public void setLogisticsName(String logisticsName) {
        this.logisticsName = logisticsName;
    }

    public String getLogisticsNo() {
        return logisticsNo;
    }

    public void setLogisticsNo(String logisticsNo) {
        this.logisticsNo = logisticsNo;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public Integer getCommissionAmount() {
        return commissionAmount;
    }

    public void setCommissionAmount(Integer commissionAmount) {
        this.commissionAmount = commissionAmount;
    }

    public Long getStaffAddTime() {
        return staffAddTime;
    }

    public void setStaffAddTime(Long staffAddTime) {
        this.staffAddTime = staffAddTime;
    }

    public List<OutboundOrderGoods> getOutboundOrderGoods() {
        return outboundOrderGoods;
    }

    public void setOutboundOrderGoods(List<OutboundOrderGoods> outboundOrderGoods) {
        this.outboundOrderGoods = outboundOrderGoods;
    }
}
