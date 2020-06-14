package com.yingtongquan.system.equipment.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class DeleteEquipment implements Serializable {

    @ApiModelProperty(value = "设备ID")
    private Integer equipmentId;

    @ApiModelProperty(value = "类型")
    private Integer type;

    //todo 回家继续

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "DeleteEquipment{" +
                "equipmentId=" + equipmentId +
                ", type=" + type +
                '}';
    }
}
