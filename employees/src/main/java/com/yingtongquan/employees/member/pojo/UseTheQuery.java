package com.yingtongquan.employees.member.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UseTheQuery implements Serializable {

    @ApiModelProperty(value = "店铺ID", hidden = true)
    private Integer shopId;

    @ApiModelProperty(value = "初始页面", hidden = true)
    private Integer pageStart;

    @ApiModelProperty(value = "每页多少个")
    private Integer pageEnd;

    @ApiModelProperty(value = "第几页")
    private Integer page;

    @ApiModelProperty(value = "名字和电话")
    private String nameAndPhone;

    @ApiModelProperty(value = "价格ID")
    private String priceId;

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getPageStart() {
        return pageStart;
    }

    public void setPageStart(Integer pageStart) {
        this.pageStart = pageStart;
    }

    public Integer getPageEnd() {
        return pageEnd;
    }

    public void setPageEnd(Integer pageEnd) {
        this.pageEnd = pageEnd;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getNameAndPhone() {
        return nameAndPhone;
    }

    public void setNameAndPhone(String nameAndPhone) {
        this.nameAndPhone = nameAndPhone;
    }

    public String getPriceId() {
        return priceId;
    }

    public void setPriceId(String priceId) {
        this.priceId = priceId;
    }

    @Override
    public String toString() {
        return "UseTheQuery{" +
                "shopId=" + shopId +
                ", pageStart=" + pageStart +
                ", pageEnd=" + pageEnd +
                ", page=" + page +
                ", nameAndPhone='" + nameAndPhone + '\'' +
                ", priceId='" + priceId + '\'' +
                '}';
    }
}
