package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StaffOrderGoods implements Serializable {

    @ApiModelProperty(value = "商品图片")
    private String image;

    @ApiModelProperty(hidden = true)
    private Integer id;

    @ApiModelProperty(value = "商品名字")
    private String orderGoodsName;

    @ApiModelProperty(hidden = true)
    private Integer goodsSkuId;

    @ApiModelProperty(value = "规格描述")
    private String skuName;

    @ApiModelProperty(hidden = true)
    private Integer goodsSkuUnitId;

    @ApiModelProperty(value = "对应的基本单位个数")
    private Integer unitAmount;

    @ApiModelProperty(value = "单位名字")
    private String name;

    @ApiModelProperty(value = "购买数量")
    private Integer amount;

    @ApiModelProperty(value = "购买价格")
    private Integer price;

    @ApiModelProperty(value = "商品原价")
    private Integer originalPrice;

    @ApiModelProperty(value = "已发货数量")
    private Integer quantityShipped;

    @ApiModelProperty(value = "条码")
    private String barcode;

    @ApiModelProperty(value = "货号")
    private String artNo;

    @ApiModelProperty(value = "店铺信息")
    private List<StoresInformation> storesInformations = new ArrayList<>();

    @ApiModelProperty(value = "仓库信息")
    private List<WarehouseInformation> warehouseInformations = new ArrayList<>();

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderGoodsName() {
        return orderGoodsName;
    }

    public void setOrderGoodsName(String orderGoodsName) {
        this.orderGoodsName = orderGoodsName;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public String getSkuName() {
        return skuName;
    }

    public void setSkuName(String skuName) {
        this.skuName = skuName;
    }

    public Integer getGoodsSkuUnitId() {
        return goodsSkuUnitId;
    }

    public void setGoodsSkuUnitId(Integer goodsSkuUnitId) {
        this.goodsSkuUnitId = goodsSkuUnitId;
    }

    public Integer getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(Integer unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Integer originalPrice) {
        this.originalPrice = originalPrice;
    }

    public Integer getQuantityShipped() {
        return quantityShipped;
    }

    public void setQuantityShipped(Integer quantityShipped) {
        this.quantityShipped = quantityShipped;
    }

    public String getBarcode() {
        return barcode;
    }

    public void setBarcode(String barcode) {
        this.barcode = barcode;
    }

    public String getArtNo() {
        return artNo;
    }

    public void setArtNo(String artNo) {
        this.artNo = artNo;
    }

    public List<StoresInformation> getStoresInformations() {
        return storesInformations;
    }

    public void setStoresInformations(List<StoresInformation> storesInformations) {
        this.storesInformations = storesInformations;
    }

    public List<WarehouseInformation> getWarehouseInformations() {
        return warehouseInformations;
    }

    public void setWarehouseInformations(List<WarehouseInformation> warehouseInformations) {
        this.warehouseInformations = warehouseInformations;
    }

    @Override
    public String toString() {
        return "StaffOrderGoods{" +
                "image='" + image + '\'' +
                ", id=" + id +
                ", orderGoodsName='" + orderGoodsName + '\'' +
                ", goodsSkuId=" + goodsSkuId +
                ", skuName='" + skuName + '\'' +
                ", goodsSkuUnitId=" + goodsSkuUnitId +
                ", unitAmount=" + unitAmount +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", originalPrice=" + originalPrice +
                ", quantityShipped=" + quantityShipped +
                ", barcode='" + barcode + '\'' +
                ", artNo='" + artNo + '\'' +
                ", storesInformations=" + storesInformations +
                ", warehouseInformations=" + warehouseInformations +
                '}';
    }
}
