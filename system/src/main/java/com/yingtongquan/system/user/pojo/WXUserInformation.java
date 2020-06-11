package com.yingtongquan.system.user.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.annotations.ApiModelProperty;

public class WXUserInformation {

    @TableId(value = "id",type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "头像")
    private String headPortrait;

    @ApiModelProperty(value = "微信openId")
    private String openId;

    @ApiModelProperty(value = "微信sessionKey")
    private String sessionKey;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String passworde;

    @ApiModelProperty(value = "盐值")
    private String saltValue;

    @ApiModelProperty(value = "注册时间")
    private Long addTime;

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

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassworde() {
        return passworde;
    }

    public void setPassworde(String passworde) {
        this.passworde = passworde;
    }

    public String getSaltValue() {
        return saltValue;
    }

    public void setSaltValue(String saltValue) {
        this.saltValue = saltValue;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    @Override
    public String toString() {
        return "WXUserInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", openId='" + openId + '\'' +
                ", sessionKey='" + sessionKey + '\'' +
                ", phone='" + phone + '\'' +
                ", account='" + account + '\'' +
                ", passworde='" + passworde + '\'' +
                ", saltValue='" + saltValue + '\'' +
                ", addTime=" + addTime +
                '}';
    }
}
