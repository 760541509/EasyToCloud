package com.yingtongquan.employees.shop.pojo;

import com.google.common.collect.Lists;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ShopInformation implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "门店名称")
    private String storeName;

    @ApiModelProperty(value = "门店图标")
    private String storeIcon;

    @ApiModelProperty(value = "门店环境")
    private String images;

    @ApiModelProperty(value = "地区id")
    private Integer areaId;

    @ApiModelProperty(value = "省")
    private String province;

    @ApiModelProperty(value = "市")
    private String city;

    @ApiModelProperty(value = "区")
    private String area;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "联系手机号")
    private String phone;

    @ApiModelProperty(value = "座机号")
    private String telephone;

    @ApiModelProperty(hidden = true,value = "注册店铺时间")
    private Long addTime;

    @ApiModelProperty(value = "店铺商品的分类")
    private List<ShopGoodsClassify> shopGoodsClassifies = Lists.newArrayList();

    @ApiModelProperty(value = "店铺收货地址")
    private List<ShopShippingAddress> shopShippingAddresses = Lists.newArrayList();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public String getStoreIcon() {
        return storeIcon;
    }

    public void setStoreIcon(String storeIcon) {
        this.storeIcon = storeIcon;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
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

    public List<ShopGoodsClassify> getShopGoodsClassifies() {
        return shopGoodsClassifies;
    }

    public void setShopGoodsClassifies(List<ShopGoodsClassify> shopGoodsClassifies) {
        this.shopGoodsClassifies = shopGoodsClassifies;
    }

    public List<ShopShippingAddress> getShopShippingAddresses() {
        return shopShippingAddresses;
    }

    public void setShopShippingAddresses(List<ShopShippingAddress> shopShippingAddresses) {
        this.shopShippingAddresses = shopShippingAddresses;
    }

    @Override
    public String toString() {
        return "ShopInformation{" +
                "id=" + id +
                ", storeName='" + storeName + '\'' +
                ", storeIcon='" + storeIcon + '\'' +
                ", images='" + images + '\'' +
                ", areaId=" + areaId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", area='" + area + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", telephone='" + telephone + '\'' +
                ", addTime=" + addTime +
                ", shopGoodsClassifies=" + shopGoodsClassifies +
                ", shopShippingAddresses=" + shopShippingAddresses +
                '}';
    }
}
