package com.yingtongquan.employees.coupons.entity;

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
 * @since 2020-06-05
 */
@TableName("tbl_coupons_lottery")
@ApiModel(value="TblCouponsLotteryPo对象", description="")
public class TblCouponsLotteryPo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "抽奖卷的内容")
    private String content;

    @ApiModelProperty(value = "获得抽奖卷的人")
    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "TblCouponsLotteryPo{" +
        "id=" + id +
        ", content=" + content +
        ", userId=" + userId +
        "}";
    }
}
