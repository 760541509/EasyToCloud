package com.yingtongquan.employees.goods.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

/**
* <p>
    * 
    * </p>
*
* @author ML
* @since 2020-05-29
*/
@ApiModel(value="商品详情", description="商品详情返回的数据")
public class TblGoodsSpuPoCall implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "门店关联商品的id")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "商品的id" )
    private Integer fkGoodsSpuId;

    @ApiModelProperty(value = "商品名称")
    private String name;

    @ApiModelProperty(value = "修改时间")
    private Long upTime;

    @ApiModelProperty(value = "商品轮播图")
    private String carouselImage;

    @ApiModelProperty(value = "商品状态（-1 已删除，0 下架，1 上架）")
    private Integer status;


    @ApiModelProperty(value = "商品的最低价")
    private Integer lowestPrice;

    @ApiModelProperty(value = "商品的最高价")
    private Integer highestPrice;

    @ApiModelProperty(value = "价格类型名称")
    private String priceName;

    @ApiModelProperty(value = "总库存")
    private Integer totalStore;

    @ApiModelProperty(value = "月销量")
    private Integer monthlySales;

    @ApiModelProperty(value = "规格描述")
    private String specDec;

    @ApiModelProperty(value = "商品的单位集合")
    private List<TblGoodsSpuUnitPo> unitList;

    @ApiModelProperty(value = "商品的SKU集合")
    private List<TblGoodsSkuPo> goodsSkuList;

    public List<TblGoodsSkuPo> getGoodsSkuList() {
        return goodsSkuList;
    }

    public void setGoodsSkuList(List<TblGoodsSkuPo> goodsSkuList) {
        this.goodsSkuList = goodsSkuList;
    }

    public List<TblGoodsSpuUnitPo> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<TblGoodsSpuUnitPo> unitList) {
        this.unitList = unitList;
    }

    public Integer getFkGoodsSpuId() {
        return fkGoodsSpuId;
    }

    public void setFkGoodsSpuId(Integer fkGoodsSpuId) {
        this.fkGoodsSpuId = fkGoodsSpuId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public String getSpecDec() {
        return specDec;
    }

    public void setSpecDec(String specDec) {
        this.specDec = specDec;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUpTime() {
        return upTime;
    }

    public void setUpTime(Long upTime) {
        this.upTime = upTime;
    }

    public String getCarouselImage() {
        return carouselImage;
    }

    public void setCarouselImage(String carouselImage) {
        this.carouselImage = carouselImage;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }


    public Integer getLowestPrice() {
        return lowestPrice;
    }

    public void setLowestPrice(Integer lowestPrice) {
        this.lowestPrice = lowestPrice;
    }

    public Integer getHighestPrice() {
        return highestPrice;
    }

    public void setHighestPrice(Integer highestPrice) {
        this.highestPrice = highestPrice;
    }

    public Integer getTotalStore() {
        return totalStore;
    }

    public void setTotalStore(Integer totalStore) {
        this.totalStore = totalStore;
    }

    public Integer getMonthlySales() {
        return monthlySales;
    }

    public void setMonthlySales(Integer monthlySales) {
        this.monthlySales = monthlySales;
    }
}


