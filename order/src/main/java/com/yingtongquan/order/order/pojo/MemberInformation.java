package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class MemberInformation implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "会员电话")
    private String phone;

    @ApiModelProperty(value = "添加时间")
    private Long addTime;

    @ApiModelProperty(value = "会员头像")
    private String headPortrail;

    @ApiModelProperty(value = "会员等级名称")
    private String priceName;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "对应会员价格的ID")
    private Integer memberId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getHeadPortrail() {
        return headPortrail;
    }

    public void setHeadPortrail(String headPortrail) {
        this.headPortrail = headPortrail;
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

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @Override
    public String toString() {
        return "MemberInformation{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", addTime=" + addTime +
                ", headPortrail='" + headPortrail + '\'' +
                ", priceName='" + priceName + '\'' +
                ", shopId=" + shopId +
                ", memberId=" + memberId +
                '}';
    }
}
