package com.yingtongquan.startcommon.pojo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

@ApiModel(value="共用的获取多条数据，参数对象")
public class CommonGetListPa implements Serializable {
    /**
     * 关键字
     */
    @ApiModelProperty(value = "关键字")
    private String keyword;

    /**
     * 门店id
     */
    @ApiModelProperty(value = "门店id")
    private Integer fkShopId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id",hidden = true)
    private Integer fkUserId;

    /**
     * 当前页的值
     */
    @ApiModelProperty(value = "当前页的值",required = true,notes = "第一页传0，按照条件排序分页，传值。")
    private Object pageValue;

    /**
     * 每页的大小
     */
    @ApiModelProperty(value = "每页的大小",required = true)
    private Integer pagePumber;



    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Object getPageValue() {
        return pageValue;
    }

    public void setPageValue(Object pageValue) {
        this.pageValue = pageValue;
    }

    public Integer getPagePumber() {
        return pagePumber;
    }

    public void setPagePumber(Integer pagePumber) {
        this.pagePumber = pagePumber;
    }

    public Integer getFkShopId() {
        return fkShopId;
    }

    public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
    }

    public Integer getFkUserId() {
        return fkUserId;
    }

    public void setFkUserId(Integer fkUserId) {
        this.fkUserId = fkUserId;
    }
}
