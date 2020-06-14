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
@ApiModel(value="TblEquipmentPrinterPo对象", description="")
public class TblEquipmentPrinterPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "设备表id")
    private Integer equipmentId;

    @ApiModelProperty(value = "识别码")
    private String mac1;

    @ApiModelProperty(value = "识别码")
    private String mac2;

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
    public String getMac1() {
        return mac1;
    }

    public void setMac1(String mac1) {
        this.mac1 = mac1;
    }
    public String getMac2() {
        return mac2;
    }

    public void setMac2(String mac2) {
        this.mac2 = mac2;
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
        ", mac1=" + mac1 +
        ", mac2=" + mac2 +
        ", mac3=" + mac3 +
        ", mac4=" + mac4 +
        ", modelId=" + modelId +
        "}";
    }
}
