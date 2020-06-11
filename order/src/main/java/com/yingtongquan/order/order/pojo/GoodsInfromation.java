package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class GoodsInfromation implements Serializable {

    @ApiModelProperty(value = "商品名字")
    private String name;

    @ApiModelProperty(value = "商品轮播图")
    private String carouselImage;

    @ApiModelProperty(value = "员工佣金百分比（按销售价格）")
    private Integer staffCommissionRate;

    @ApiModelProperty(value = "分销商佣金百分比（按销售价格）")
    private Integer distributorCommissionRate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarouselImage() {
        return carouselImage;
    }

    public void setCarouselImage(String carouselImage) {
        this.carouselImage = carouselImage;
    }

    public Integer getStaffCommissionRate() {
        return staffCommissionRate;
    }

    public void setStaffCommissionRate(Integer staffCommissionRate) {
        this.staffCommissionRate = staffCommissionRate;
    }

    public Integer getDistributorCommissionRate() {
        return distributorCommissionRate;
    }

    public void setDistributorCommissionRate(Integer distributorCommissionRate) {
        this.distributorCommissionRate = distributorCommissionRate;
    }

    @Override
    public String toString() {
        return "GoodsInfromation{" +
                "name='" + name + '\'' +
                ", carouselImage='" + carouselImage + '\'' +
                ", staffCommissionRate='" + staffCommissionRate + '\'' +
                ", distributorCommissionRate='" + distributorCommissionRate + '\'' +
                '}';
    }
}
