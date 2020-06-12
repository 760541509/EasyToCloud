package com.yingtongquan.employees.staff.pojo;

import java.io.Serializable;

public class MemberInformation implements Serializable {

    private String memberName;

    private Integer Id;

    private String headPortrait;

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public Integer getId() {
        return Id;
    }

    public void setId(Integer id) {
        Id = id;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    @Override
    public String toString() {
        return "MemberInformation{" +
                "memberName='" + memberName + '\'' +
                ", Id=" + Id +
                ", headPortrait='" + headPortrait + '\'' +
                '}';
    }
}
