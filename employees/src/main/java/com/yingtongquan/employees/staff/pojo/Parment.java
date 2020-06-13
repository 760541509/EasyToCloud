package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class Parment implements Serializable {

    @ApiModelProperty(value = "状态")
    private Integer status;

    @ApiModelProperty(value = "会员电话,会员名称,订单号")
    private String keyword;

    @ApiModelProperty(value = "第几页")
    private Integer page;

    @ApiModelProperty(hidden = true)
    private Integer pageStart;

    @ApiModelProperty(value = "每页多少条")
    private Integer pageEnd;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
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

    @Override
    public String toString() {
        return "Parment{" +
                "status=" + status +
                ", keyword='" + keyword + '\'' +
                ", page=" + page +
                ", pageStart=" + pageStart +
                ", pageEnd=" + pageEnd +
                '}';
    }
}
