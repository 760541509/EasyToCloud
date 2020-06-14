package com.yingtongquan.system.equipment.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Printer implements Serializable {

    @ApiModelProperty(value = "打印机型号名称")
    private String printerName;

    @ApiModelProperty(value = "纸张大小")
    private Integer paperSize;

    @ApiModelProperty(value = "状态（0 不启用，1启用,默认填0 启动）")
    private Integer printerState;

    @ApiModelProperty(value = "校验码")
    private String checkCode;

    @ApiModelProperty(value = "制造编码")
    private String makeCoding;

    @ApiModelProperty(hidden = true)
    private String mac3;

    @ApiModelProperty(hidden = true)
    private String mac4;

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

    @Override
    public String toString() {
        return "Printer{" +
                "printerName='" + printerName + '\'' +
                ", paperSize=" + paperSize +
                ", printerState=" + printerState +
                ", checkCode='" + checkCode + '\'' +
                ", makeCoding='" + makeCoding + '\'' +
                ", mac3='" + mac3 + '\'' +
                ", mac4='" + mac4 + '\'' +
                '}';
    }
}
