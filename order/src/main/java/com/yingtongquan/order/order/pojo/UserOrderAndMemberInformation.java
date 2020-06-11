package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class UserOrderAndMemberInformation implements Serializable {

    @ApiModelProperty(value = "会员ID")
    private Integer memberId;

    @ApiModelProperty(value = "会员价格ID")
    private Integer memberShopPriceId;

    @ApiModelProperty(value = "会员收货地址")
    private Integer memberShopAddressId;

    @ApiModelProperty(value = "是否自提")
    private Integer isSince;

    @ApiModelProperty(value = "商品信息")
    private List<OrderGoods> orderGoods = new ArrayList<OrderGoods>();

    @ApiModelProperty(value = "订单类型")
    private Integer orderType;

    @ApiModelProperty(value = "订单渠道")
    private Integer orderChannel;

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public Integer getMemberShopPriceId() {
        return memberShopPriceId;
    }

    public void setMemberShopPriceId(Integer memberShopPriceId) {
        this.memberShopPriceId = memberShopPriceId;
    }

    public Integer getMemberShopAddressId() {
        return memberShopAddressId;
    }

    public void setMemberShopAddressId(Integer memberShopAddressId) {
        this.memberShopAddressId = memberShopAddressId;
    }

    public Integer getIsSince() {
        return isSince;
    }

    public void setIsSince(Integer isSince) {
        this.isSince = isSince;
    }

    public List<OrderGoods> getOrderGoods() {
        return orderGoods;
    }

    public void setOrderGoods(List<OrderGoods> orderGoods) {
        this.orderGoods = orderGoods;
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getOrderChannel() {
        return orderChannel;
    }

    public void setOrderChannel(Integer orderChannel) {
        this.orderChannel = orderChannel;
    }

    @Override
    public String toString() {
        return "UserOrderAndMemberInformation{" +
                "memberId=" + memberId +
                ", memberShopPriceId=" + memberShopPriceId +
                ", memberShopAddressId=" + memberShopAddressId +
                ", isSince=" + isSince +
                ", orderGoods=" + orderGoods +
                ", orderType=" + orderType +
                ", orderChannel=" + orderChannel +
                '}';
    }
}
