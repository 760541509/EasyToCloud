package com.yingtongquan.employees.warehouse.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class WarehouseInformation implements Serializable {

    @ApiModelProperty(value = "仓库名称")
    private String warehouseName;

    @ApiModelProperty(hidden = true)
    private Integer DontAllow;

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public Integer getDontAllow() {
        return DontAllow;
    }

    public void setDontAllow(Integer dontAllow) {
        DontAllow = dontAllow;
    }

}
