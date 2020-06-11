package com.yingtongquan.system.user.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UserRegis implements Serializable {

    @ApiModelProperty(value = "手机号")
    private String phone;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "第三方验证码")
    private String msgId;

    @ApiModelProperty(value = "验证码")
    private String checkCode;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMsgId() {
        return msgId;
    }

    public void setMsgId(String msgId) {
        this.msgId = msgId;
    }

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    @Override
    public String toString() {
        return "UserRegis{" +
                "phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", msgId='" + msgId + '\'' +
                ", checkCode='" + checkCode + '\'' +
                '}';
    }
}
