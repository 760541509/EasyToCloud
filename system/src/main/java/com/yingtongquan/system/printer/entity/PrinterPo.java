package com.yingtongquan.system.printer.entity;

import java.io.Serializable;

public class PrinterPo implements Serializable {

    private String token;

    private Long addTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
}
