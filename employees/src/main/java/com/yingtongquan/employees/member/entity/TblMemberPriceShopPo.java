package com.yingtongquan.employees.member.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@TableName("tbl_member_price_shop")
@ApiModel(value = "TblMemberPriceShopPo对象", description = "")
public class TblMemberPriceShopPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "名称")
    private String priceName;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "状态（0 不启用，1启用）")
    private Integer status;

    @ApiModelProperty(value = "类型（0 零售，1批发）")
    private Integer type;

    @ApiModelProperty(value = "上级ID（零售价和批发价各只有一个为0））")
    private Integer supId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPriceName() {
        return priceName;
    }

    public void setPriceName(String priceName) {
        this.priceName = priceName;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getSupId() {
        return supId;
    }

    public void setSupId(Integer supId) {
        this.supId = supId;
    }

    @Override
    public String toString() {
        return "TblMemberPriceShopPo{" +
                "id=" + id +
                ", priceName='" + priceName + '\'' +
                ", shopId=" + shopId +
                ", status=" + status +
                ", type=" + type +
                ", supId=" + supId +
                '}';
    }
}
