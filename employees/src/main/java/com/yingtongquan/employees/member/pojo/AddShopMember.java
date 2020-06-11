package com.yingtongquan.employees.member.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class AddShopMember implements Serializable {

    @ApiModelProperty(value = "手机号码")
    private String account;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "享受的会员等级ID")
    private Integer memberPriceId;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getMemberPriceId() {
        return memberPriceId;
    }

    public void setMemberPriceId(Integer memberPriceId) {
        this.memberPriceId = memberPriceId;
    }

    @Override
    public String toString() {
        return "AddShopMember{" +
                "account='" + account + '\'' +
                ", shopId=" + shopId +
                ", memberPriceId=" + memberPriceId +
                '}';
    }
}
