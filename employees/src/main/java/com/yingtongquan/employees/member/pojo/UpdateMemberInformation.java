package com.yingtongquan.employees.member.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class UpdateMemberInformation implements Serializable {

    @ApiModelProperty(value = "会员ID")
    private Integer id;

    @ApiModelProperty(value = "会员名字")
    private String name;

    @ApiModelProperty(value = "会员电话")
    private String phone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "UpdateMemberInformation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
