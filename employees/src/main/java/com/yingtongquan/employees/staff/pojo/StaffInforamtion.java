package com.yingtongquan.employees.staff.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class StaffInforamtion implements Serializable {

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "员工电话")
    private String phone;

    @ApiModelProperty(value = "地区ID")
    private Integer areaId;

    @ApiModelProperty(value = "详细地址")
    private String address;

    @ApiModelProperty(value = "员工权限ID")
    private Integer staffRoleId;

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

    public Integer getStaffRoleId() {
        return staffRoleId;
    }

    public void setStaffRoleId(Integer staffRoleId) {
        this.staffRoleId = staffRoleId;
    }

    @Override
    public String toString() {
        return "StaffInforamtion{" +
                "name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", areaId=" + areaId +
                ", address='" + address + '\'' +
                ", staffRoleId=" + staffRoleId +
                '}';
    }
}
