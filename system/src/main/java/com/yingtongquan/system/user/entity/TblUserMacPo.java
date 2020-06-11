package com.yingtongquan.system.user.entity;

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
 * @since 2020-05-06
 */
@TableName("tbl_user_mac")
@ApiModel(value="TblUserMacPo对象", description="")
public class TblUserMacPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID")
    private Integer userId;

    @ApiModelProperty(value = "用户授权的MAC地址")
    private String mac;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
    }

    @Override
    public String toString() {
        return "TblUserMacPo{" +
        "userId=" + userId +
        ", mac=" + mac +
        "}";
    }
}
