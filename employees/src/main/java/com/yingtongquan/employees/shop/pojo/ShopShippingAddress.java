package com.yingtongquan.employees.shop.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ShopShippingAddress implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "添加时间")
    private Long addTime;

    @ApiModelProperty(value = "收货人电话")
    private String phone;

    @ApiModelProperty(value = "收货人姓名")
    private String name;

    @ApiModelProperty(value = "地区ID")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "是否默认为收货地址（0否，1是）")
    private Integer isDefault;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getIsDefault() {
        return isDefault;
    }

    public void setIsDefault(Integer isDefault) {
        this.isDefault = isDefault;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ShopShippingAddress{" +
                "id=" + id +
                ", addTime=" + addTime +
                ", phone='" + phone + '\'' +
                ", name='" + name + '\'' +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", isDefault=" + isDefault +
                ", shopId=" + shopId +
                '}';
    }
}
