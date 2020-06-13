package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class OutboundShippingAddress implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "出库单的id")
    private Integer outboundOrderId;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "门店会员外键")
    private Integer memberShopId;

    @ApiModelProperty(value = "联系手机号")
    private String phone;

    @ApiModelProperty(value = "联系人名称")
    private String name;

    @ApiModelProperty(value = "地区外键id")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "是否自提（0 自提，1 物流）")
    private Integer isSince;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOutboundOrderId() {
        return outboundOrderId;
    }

    public void setOutboundOrderId(Integer outboundOrderId) {
        this.outboundOrderId = outboundOrderId;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
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

    @Override
    public String toString() {
        return "OutboundShippingAddress{" +
                "id=" + id +
                ", outboundOrderId=" + outboundOrderId +
                ", addTime=" + addTime +
                ", memberShopId=" + memberShopId +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", isSince=" + isSince +
                '}';
    }
}
