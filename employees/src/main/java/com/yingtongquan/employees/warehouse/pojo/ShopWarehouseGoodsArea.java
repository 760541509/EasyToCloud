package com.yingtongquan.employees.warehouse.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ShopWarehouseGoodsArea implements Serializable {

    private Integer warehouseId;

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(value = "地区id")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "精度")
    private Double longitude;

    @ApiModelProperty(value = "联系手机号")
    private String phone;

    @ApiModelProperty(value = "座机号")
    private String telephone;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "区域")
    private List<WarehouseArea> warehouseAreas = Lists.newArrayList();

    public Integer getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Integer warehouseId) {
        this.warehouseId = warehouseId;
    }

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public List<WarehouseArea> getWarehouseAreas() {
        return warehouseAreas;
    }

    public void setWarehouseAreas(List<WarehouseArea> warehouseAreas) {
        this.warehouseAreas = warehouseAreas;
    }

    @Override
    public String toString() {
        return "ShopWarehouseGoodsArea{" +
                "warehouseId=" + warehouseId +
                ", warehouseName='" + warehouseName + '\'' +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", addTime=" + addTime +
                ", warehouseAreas=" + warehouseAreas +
                '}';
    }
}
