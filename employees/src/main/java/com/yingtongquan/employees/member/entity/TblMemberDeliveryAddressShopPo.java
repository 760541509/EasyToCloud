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
@TableName("tbl_member_delivery_address_shop")
@ApiModel(value = "TblMemberDeliveryAddressShopPo对象", description = "")
public class TblMemberDeliveryAddressShopPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "门店会员ID")
    private Integer memberShopId;

    @ApiModelProperty(value = "收货人姓名")
    private String name;

    @ApiModelProperty(value = "联系手机号")
    private String phone;

    @ApiModelProperty(value = "地区ID")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "纬度")
    private Double latitude;

    @ApiModelProperty(value = "精度")
    private Double longitude;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMemberShopId() {
        return memberShopId;
    }

    public void setMemberShopId(Integer memberShopId) {
        this.memberShopId = memberShopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString() {
        return "TblMemberDeliveryAddressShopPo{" +
                "id=" + id +
                ", memberShopId=" + memberShopId +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                '}';
    }
}
