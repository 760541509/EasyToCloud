package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ShopMemberPrice implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "名称")
    private String priceName;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    @Override
    public String toString() {
        return "ShopMemberPrice{" +
                "id=" + id +
                ", priceName='" + priceName + '\'' +
                ", shopId=" + shopId +
                '}';
    }
}
