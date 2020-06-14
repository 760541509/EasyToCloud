package com.yingtongquan.system.equipment.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UpdateEquipment implements Serializable {

    private Integer id;

    @ApiModelProperty(value = "员工ID（注：修改为另一位员工名下时传）")
    private Integer staffId;

    @ApiModelProperty(value = "设备名称")
    private String name;

    @ApiModelProperty(value = "设备类型（0,手机设备，1,PDA设备，2 打印机设备，3 自动售货机设备）")
    private Integer type;

    @ApiModelProperty(value = "状态（0 不启用，1启用,默认填0 启动）")
    private Integer phoneState;

    @ApiModelProperty(value = "状态（0 不启用，1启用,默认填0 启动）")
    private Integer PDAState;

    @ApiModelProperty(value = "打印机型号名称")
    private String printerName;

    @ApiModelProperty(value = "纸张大小")
    private Integer paperSize;

    @ApiModelProperty(value = "状态（0 不启用，1启用,默认填0 启动）")
    private Integer printerState;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getPhoneState() {
        return phoneState;
    }

    public void setPhoneState(Integer phoneState) {
        this.phoneState = phoneState;
    }

    public Integer getPDAState() {
        return PDAState;
    }

    public void setPDAState(Integer PDAState) {
        this.PDAState = PDAState;
    }

    public String getPrinterName() {
        return printerName;
    }

    public void setPrinterName(String printerName) {
        this.printerName = printerName;
    }

    public Integer getPaperSize() {
        return paperSize;
    }

    public void setPaperSize(Integer paperSize) {
        this.paperSize = paperSize;
    }

    public Integer getPrinterState() {
        return printerState;
    }

    public void setPrinterState(Integer printerState) {
        this.printerState = printerState;
    }

    @Override
    public String toString() {
        return "UpdateEquipment{" +
                "id=" + id +
                ", staffId=" + staffId +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", phoneState=" + phoneState +
                ", PDAState=" + PDAState +
                ", printerName='" + printerName + '\'' +
                ", paperSize=" + paperSize +
                ", printerState=" + printerState +
                '}';
    }
}
