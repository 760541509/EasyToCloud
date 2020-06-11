package com.yingtongquan.system.user.pojo;

import io.swagger.annotations.ApiModelProperty;

public class WXUserBindPhone {

    @ApiModelProperty(value = "偏移量")
    private String iv;

    @ApiModelProperty(value = "加密的数据")
    private String encryptedData;

    public String getIv() {
        return iv;
    }

    public void setIv(String iv) {
        this.iv = iv;
    }

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    @Override
    public String toString() {
        return "WXUserBandPhone{" +
                "iv='" + iv + '\'' +
                ", encryptedData='" + encryptedData + '\'' +
                '}';
    }

}
