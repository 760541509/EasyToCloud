package com.yingtongquan.employees.member.pojo;

import com.google.common.collect.Lists;
import com.yingtongquan.employees.member.entity.TblMemberPriceShopPo;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.List;

public class ShopPrice implements Serializable {

    @ApiModelProperty(value = "零售价")
    private List<TblMemberPriceShopPo> retailPrice = Lists.newArrayList();

    @ApiModelProperty(value = "批发价")
    private List<TblMemberPriceShopPo> wholesalePrice = Lists.newArrayList();

    public ShopPrice() {
    }

    public ShopPrice(List<TblMemberPriceShopPo> retailPrice, List<TblMemberPriceShopPo> wholesalePrice) {
        this.retailPrice = retailPrice;
        this.wholesalePrice = wholesalePrice;
    }

    public List<TblMemberPriceShopPo> getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(List<TblMemberPriceShopPo> retailPrice) {
        this.retailPrice = retailPrice;
    }

    public List<TblMemberPriceShopPo> getWholesalePrice() {
        return wholesalePrice;
    }

    public void setWholesalePrice(List<TblMemberPriceShopPo> wholesalePrice) {
        this.wholesalePrice = wholesalePrice;
    }

    @Override
    public String toString() {
        return "ShopPrice{" +
                "retailPrice=" + retailPrice +
                ", wholesalePrice=" + wholesalePrice +
                '}';
    }
}
