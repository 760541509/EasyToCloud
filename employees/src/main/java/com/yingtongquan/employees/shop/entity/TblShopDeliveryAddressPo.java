package com.yingtongquan.employees.shop.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@TableName("tbl_shop_delivery_address")
public class TblShopDeliveryAddressPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "门店id外键")
    private Integer shopId;

    @ApiModelProperty(value = "联系手机号")
    private String phone;

    @ApiModelProperty(value = "联系人名称")
    private String name;

    @ApiModelProperty(value = "地区外键id")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "是否默认（0 否，1是）")
    private Integer isDefault;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "精度")
    private Double longitude;

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
    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
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
    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }
    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "TblShopDeliveryAddressPo{" +
        "id=" + id +
        ", addTime=" + addTime +
        ", shopId=" + shopId +
        ", phone=" + phone +
        ", name=" + name +
        ", areaId=" + areaId +
        ", address=" + address +
        ", isDefault=" + isDefault +
        ", latitude=" + latitude +
        ", longitude=" + longitude +
        "}";
    }
}
