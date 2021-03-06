package com.yingtongquan.employees.member.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ShopMemberInfo implements Serializable {

    @ApiModelProperty(value = "会员ID")
    private Integer id;

    @ApiModelProperty(value = "会员名字")
    private String name;

    @ApiModelProperty(value = "会员电话")
    private String phone;

    @ApiModelProperty(value = "会员头像")
    private String headPortrait;

    @ApiModelProperty(value = "注册时间")
    private Long addTime;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "收货地址详细")
    private List<MemberAddress> memberAddresses = new ArrayList<>();

    @ApiModelProperty(value = "是否绑定微信")
    private Boolean bindWeChat;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public List<MemberAddress> getMemberAddresses() {
        return memberAddresses;
    }

    public void setMemberAddresses(List<MemberAddress> memberAddresses) {
        this.memberAddresses = memberAddresses;
    }

    public Boolean getBindWeChat() {
        return bindWeChat;
    }

    public void setBindWeChat(Boolean bindWeChat) {
        this.bindWeChat = bindWeChat;
    }

    @Override
    public String toString() {
        return "ShopMemberInfo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", addTime=" + addTime +
                ", userId=" + userId +
                ", memberAddresses=" + memberAddresses +
                ", bindWeChat=" + bindWeChat +
                '}';
    }
}
