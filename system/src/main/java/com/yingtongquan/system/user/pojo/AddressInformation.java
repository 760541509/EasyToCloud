package com.yingtongquan.system.user.pojo;

import java.io.Serializable;

public class AddressInformation implements Serializable {

    //地区编号
    private Integer areaId;
    //省
    private String province;
    //市
    private String city;
    //区
    private String district;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    @Override
    public String toString() {
        return "AddressInformation{" +
                "areaId=" + areaId +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
