package com.yingtongquan.employees.member.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class MemberAddress implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "区域ID")
    private Integer areaId;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "收货人姓名")
    private String consignee;

    @ApiModelProperty(value = "收货人电话")
    private String phone;

    @ApiModelProperty(value = "会员ID（注:该属性只能是只添加地址的情况下才传）")
    private Integer memberId;

    @ApiModelProperty(value = "纬度")
    private double latitude;

    @ApiModelProperty(value = "经度")
    private double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "MemberAddress{" +
                "id=" + id +
                ", areaId=" + areaId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", consignee='" + consignee + '\'' +
                ", phone='" + phone + '\'' +
                ", memberId=" + memberId +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
