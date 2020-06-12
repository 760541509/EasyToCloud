package com.yingtongquan.employees.member.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class MemberInformation implements Serializable {

    @ApiModelProperty(value = "会员ID")
    private Integer id;

    @ApiModelProperty(value = "会员名字")
    private String memberName;

    @ApiModelProperty(value = "会员电话")
    private String phone;

    @ApiModelProperty(value = "会员头像")
    private String headPortrait;

    @ApiModelProperty(hidden = true)
    private Integer userId;

    @ApiModelProperty(value = "最近一次下单时间")
    private Long addTime;

    @ApiModelProperty(value = "是否绑定微信(true 已绑定 false 没绑定)")
    private Boolean bindWeChat;

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

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public Boolean getBindWeChat() {
        return bindWeChat;
    }

    public void setBindWeChat(Boolean bindWeChat) {
        this.bindWeChat = bindWeChat;
    }

    @Override
    public String toString() {
        return "MemberInformation{" +
                "id=" + id +
                ", memberName='" + memberName + '\'' +
                ", phone='" + phone + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", userId=" + userId +
                ", addTime=" + addTime +
                ", bindWeChat=" + bindWeChat +
                '}';
    }
}
