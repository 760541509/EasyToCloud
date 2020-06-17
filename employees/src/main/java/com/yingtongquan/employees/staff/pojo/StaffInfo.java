package com.yingtongquan.employees.staff.pojo;

import java.io.Serializable;

public class StaffInfo implements Serializable {

    private Integer id;

    private String staffName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }
}
