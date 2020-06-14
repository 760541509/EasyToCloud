package com.yingtongquan.system.equipment.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * <p>
 *
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
@TableName("tbl_equipment_pda")
@ApiModel(value = "TblEquipmentPdaPo对象", description = "")
public class TblEquipmentPdaPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备表id")
    private Integer equipmentId;

    @ApiModelProperty(value = "唯一识别码")
    private String mac;

    @ApiModelProperty(value = "状态（0 不启用，1启用）")
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(Integer equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override

    public String toString() {
        return "TblEquipmentPdaPo{" +
                "id=" + id +
                ", equipmentId=" + equipmentId +
                ", mac='" + mac + '\'' +
                ", state=" + state +
                '}';
    }
}
