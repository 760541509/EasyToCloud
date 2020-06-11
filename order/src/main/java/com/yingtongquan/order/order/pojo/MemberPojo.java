package com.yingtongquan.order.order.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class MemberPojo implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "联系手机号")
    private String phone;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "头像(根据用户表改变)")
    private String headPortrait;

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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
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
        return "MemberPojo{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", userId=" + userId +
                ", phone='" + phone + '\'' +
                ", addTime=" + addTime +
                ", headPortrait='" + headPortrait + '\'' +
                ", shopId=" + shopId +
                ", memberId=" + memberId +
                '}';
    }
}
