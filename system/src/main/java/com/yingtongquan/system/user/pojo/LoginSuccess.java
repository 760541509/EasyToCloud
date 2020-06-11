package com.yingtongquan.system.user.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class LoginSuccess implements Serializable {

    private int id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "账户名")
    private String username;

    @ApiModelProperty(value = "头像")
    private String headPortrait;

    @ApiModelProperty(value = "注册时间")
    private Long addTime;

    @ApiModelProperty(value = "电话")
    private String phone;

    @ApiModelProperty(value = "token")
    private String token;

    @ApiModelProperty(value = "店铺ID")
    private Integer shopId;

    @ApiModelProperty(value = "店铺图标")
    private String storeIcon;

    @ApiModelProperty(value = "员工ID")
    private Integer staffId;

    @ApiModelProperty(value = "员工姓名")
    private String staffName;

    @ApiModelProperty(value = "员工手机号")
    private String staffPhone;

    @ApiModelProperty(value = "权限名称")
    private String roleName;

    @ApiModelProperty(value = "资源数据  0 老板  1 店长  2 开单  3 修改商品  4 ......")
    private String resources;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public Long getAddTime() {
        return addTime;
    }

    public void setAddTime(Long addTime) {
        this.addTime = addTime;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public String getStoreIcon() {
        return storeIcon;
    }

    public void setStoreIcon(String storeIcon) {
        this.storeIcon = storeIcon;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public String getStaffPhone() {
        return staffPhone;
    }

    public void setStaffPhone(String staffPhone) {
        this.staffPhone = staffPhone;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getResources() {
        return resources;
    }

    public void setResources(String resources) {
        this.resources = resources;
    }

    @Override
    public String toString() {
        return "LoginSuccess{" +
                "id=" + id +
                ", account='" + account + '\'' +
                ", username='" + username + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", addTime=" + addTime +
                ", phone='" + phone + '\'' +
                ", token='" + token + '\'' +
                ", shopId=" + shopId +
                ", storeIcon='" + storeIcon + '\'' +
                ", staffId=" + staffId +
                ", staffName='" + staffName + '\'' +
                ", staffPhone='" + staffPhone + '\'' +
                ", roleName='" + roleName + '\'' +
                ", resources='" + resources + '\'' +
                '}';
    }
}
