package com.yingtongquan.order.returnGoods.entity;

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
 * @author Pang
 * @since 2020-05-12
 */
@TableName("tbl_return_order_delivery_address")
@ApiModel(value="TblReturnOrderDeliveryAddressPo对象", description="")
public class TblReturnOrderDeliveryAddressPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "退货单的id")
    private Integer returnOrderId;

    @ApiModelProperty(value = "创建时间")
    private Long addTime;

    @ApiModelProperty(value = "门店收货地址外键")
    private Integer shopDeliveryAddressId;

    @ApiModelProperty(value = "联系手机号")
    private String phone;

    @ApiModelProperty(value = "联系人名称")
    private String name;

    @ApiModelProperty(value = "地区外键id")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "退货方式（0 门店退货，1 物流）")
    private Integer isSince;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public Integer getReturnOrderId() {
        return returnOrderId;
    }

    public void setReturnOrderId(Integer returnOrderId) {
        this.returnOrderId = returnOrderId;
    }
    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }
    public Integer getShopDeliveryAddressId() {
        return shopDeliveryAddressId;
    }

    public void setShopDeliveryAddressId(Integer shopDeliveryAddressId) {
        this.shopDeliveryAddressId = shopDeliveryAddressId;
    }
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public Integer getIsSince() {
        return isSince;
    }

    public void setIsSince(Integer isSince) {
        this.isSince = isSince;
    }

    @Override
    public String toString() {
        return "TblReturnOrderDeliveryAddressPo{" +
        "id=" + id +
        ", returnOrderId=" + returnOrderId +
        ", addTime=" + addTime +
        ", shopDeliveryAddressId=" + shopDeliveryAddressId +
        ", phone=" + phone +
        ", name=" + name +
        ", areaId=" + areaId +
        ", address=" + address +
        ", isSince=" + isSince +
        "}";
    }
}
