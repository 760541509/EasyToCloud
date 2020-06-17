package com.yingtongquan.employees.staff.pojo;

import java.io.Serializable;

public class SkuUnitInfo implements Serializable {

    //条形码
    private String barCode;

    //货号
    private String artNo;

    //规格值
    private String specValue;

    public String getBarCode() {
        return barCode;
    }

    public void setBarCode(String barCode) {
        this.barCode = barCode;
    }

    public String getArtNo() {
        return artNo;
    }

    public void setArtNo(String artNo) {
        this.artNo = artNo;
    }

    public String getSpecValue() {
        return specValue;
    }

    public void setSpecValue(String specValue) {
        this.specValue = specValue;
    }
}
