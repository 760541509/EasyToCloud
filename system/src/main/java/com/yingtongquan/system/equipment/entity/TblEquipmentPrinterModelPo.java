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
@TableName("tbl_equipment_printer_model")
@ApiModel(value="TblEquipmentPrinterModelPo对象", description="")
public class TblEquipmentPrinterModelPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "型号名称")
    private String name;

    @ApiModelProperty(value = "纸张大小")
    private Integer paperSize;

    @ApiModelProperty(value = "状态（0 不启用，1启用）")
    private Integer state;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(Integer paperSize) {
        this.paperSize = paperSize;
    }
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "TblEquipmentPrinterModelPo{" +
        "id=" + id +
        ", name=" + name +
        ", paperSize=" + paperSize +
        ", state=" + state +
        "}";
    }
}
