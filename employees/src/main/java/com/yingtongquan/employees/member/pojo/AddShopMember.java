package com.yingtongquan.employees.member.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AddShopMember implements Serializable {

    @ApiModelProperty(value = "手机号码")
    private String account;

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "享受的会员等级ID")
    private Integer memberPriceId;

    @ApiModelProperty(value = "收货地址")
    private List<MemberAddress> memberAddresses = new ArrayList<>();

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMemberPriceId() {
        return memberPriceId;
    }

    public void setMemberPriceId(Integer memberPriceId) {
        this.memberPriceId = memberPriceId;
    }

    public List<MemberAddress> getMemberAddresses() {
        return memberAddresses;
    }

    public void setMemberAddresses(List<MemberAddress> memberAddresses) {
        this.memberAddresses = memberAddresses;
    }

    @Override
    public String toString() {
        return "AddShopMember{" +
                "account='" + account + '\'' +
                ", name='" + name + '\'' +
                ", memberPriceId=" + memberPriceId +
                ", memberAddresses=" + memberAddresses +
                '}';
    }
}
