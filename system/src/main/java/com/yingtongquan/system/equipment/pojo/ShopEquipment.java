package com.yingtongquan.system.equipment.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class ShopEquipment implements Serializable {

    @ApiModelProperty(value = "设备名称")
    private String name;

    @ApiModelProperty(value = "设备类型（0,手机设备，1,PDA设备，2 打印机设备，3 自动售货机设备）")
    private Integer type;

    @ApiModelProperty(value = "手机MAC")
    private String phoneMac;

    @ApiModelProperty(value = "状态（0 不启用，1启用,默认填0 启动）")
    private Integer phoneState;

    @ApiModelProperty(value = "PDAMAC")
    private String PDAMac;

    @ApiModelProperty(value = "状态（0 不启用，1启用,默认填0 启动）")
    private Integer PDAState;

    @ApiModelProperty(value = "打印机相关信息(注:这里不是集合，请勿传集合过来，否则会报错)")
    private Printer printer;

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

    public String getPhoneMac() {
        return phoneMac;
    }

    public void setPhoneMac(String phoneMac) {
        this.phoneMac = phoneMac;
    }

    public Integer getPhoneState() {
        return phoneState;
    }

    public void setPhoneState(Integer phoneState) {
        this.phoneState = phoneState;
    }

    public String getPDAMac() {
        return PDAMac;
    }

    public void setPDAMac(String PDAMac) {
        this.PDAMac = PDAMac;
    }

    public Integer getPDAState() {
        return PDAState;
    }

    public void setPDAState(Integer PDAState) {
        this.PDAState = PDAState;
    }

    public Printer getPrinter() {
        return printer;
    }

    public void setPrinter(Printer printer) {
        this.printer = printer;
    }

    @Override
    public String toString() {
        return "ShopEquipment{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", phoneMac='" + phoneMac + '\'' +
                ", phoneState=" + phoneState +
                ", PDAMac='" + PDAMac + '\'' +
                ", PDAState=" + PDAState +
                ", printer=" + printer +
                '}';
    }
}
