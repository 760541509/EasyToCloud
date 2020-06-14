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
@TableName("tbl_equipment_printer")
@ApiModel(value = "TblEquipmentPrinterPo对象", description = "")
public class TblEquipmentPrinterPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备表id")
    private Integer equipmentId;

    @ApiModelProperty(value = "校验码")
    private String checkCode;

    @ApiModelProperty(value = "制造编码")
    private String makeCoding;

    @ApiModelProperty(value = "识别码")
    private String mac3;

    @ApiModelProperty(value = "识别码")
    private String mac4;

    @ApiModelProperty(value = "型号")
    private Integer modelId;

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

    public String getCheckCode() {
        return checkCode;
    }

    public void setCheckCode(String checkCode) {
        this.checkCode = checkCode;
    }

    public String getMakeCoding() {
        return makeCoding;
    }

    public void setMakeCoding(String makeCoding) {
        this.makeCoding = makeCoding;
    }

    public String getMac3() {
        return mac3;
    }

    public void setMac3(String mac3) {
        this.mac3 = mac3;
    }

    public String getMac4() {
        return mac4;
    }

    public void setMac4(String mac4) {
        this.mac4 = mac4;
    }

    public Integer getModelId() {
        return modelId;
    }

    public void setModelId(Integer modelId) {
        this.modelId = modelId;
    }

    @Override
    public String toString() {
        return "TblEquipmentPrinterPo{" +
                "id=" + id +
                ", equipmentId=" + equipmentId +
                ", checkCode='" + checkCode + '\'' +
                ", makeCoding='" + makeCoding + '\'' +
                ", mac3='" + mac3 + '\'' +
                ", mac4='" + mac4 + '\'' +
                ", modelId=" + modelId +
                '}';
    }
}
