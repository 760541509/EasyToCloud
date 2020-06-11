package com.yingtongquan.system.user.pojo;

import java.io.Serializable;

public class RotaryTable implements Serializable {

    private Integer id;

    //转盘区域数量
    private Integer areaNumber;

    //属于那个店铺的转盘，对应配置表里的转盘ID
    private Integer attributable;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAreaNumber() {
        return areaNumber;
    }

    public void setAreaNumber(Integer areaNumber) {
        this.areaNumber = areaNumber;
    }

    public Integer getAttributable() {
        return attributable;
    }

    public void setAttributable(Integer attributable) {
        this.attributable = attributable;
    }

    @Override
    public String toString() {
        return "RotaryTable{" +
                "id=" + id +
                ", areaNumber=" + areaNumber +
                ", attributable=" + attributable +
                '}';
    }
}
