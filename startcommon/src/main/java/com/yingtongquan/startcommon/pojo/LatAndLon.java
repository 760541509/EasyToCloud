package com.yingtongquan.startcommon.pojo;

import java.io.Serializable;

public class LatAndLon implements Serializable {

    //经度
    private Float lat;

    //纬度
    private Float lon;

    //省
    private String province;

    //市
    private String city;

    //区
    private String district;

    public Float getLat() {
        return lat;
    }

    public void setLat(Float lat) {
        this.lat = lat;
    }

    public Float getLon() {
        return lon;
    }

    public void setLon(Float lon) {
        this.lon = lon;
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
        return "LatAndLon{" +
                "lat=" + lat +
                ", lon=" + lon +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", district='" + district + '\'' +
                '}';
    }
}
