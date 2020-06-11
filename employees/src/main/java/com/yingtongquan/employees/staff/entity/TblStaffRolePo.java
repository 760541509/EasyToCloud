package com.yingtongquan.employees.staff.entity;

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
@TableName("tbl_staff_role")
@ApiModel(value = "TblStaffRolePo对象", description = "")
public class TblStaffRolePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "权限名称")
    private String roleName;

    @ApiModelProperty(value = "资源数据  0 老板  1 店长  2 开单  3 修改商品  4 ......")
    private String resources;

    @ApiModelProperty(value = "门店id")
    private Integer shopId;

    @ApiModelProperty(value = "员工佣金百分比")
    private Integer staffCommissionRate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getShopId() {
        return shopId;
    }

    public void setShopId(Integer shopId) {
        this.shopId = shopId;
    }

    public Integer getStaffCommissionRate() {
        return staffCommissionRate;
    }

    public void setStaffCommissionRate(Integer staffCommissionRate) {
        this.staffCommissionRate = staffCommissionRate;
    }

    @Override
    public String toString() {
        return "TblStaffRolePo{" +
                "id=" + id +
                ", roleName='" + roleName + '\'' +
                ", resources='" + resources + '\'' +
                ", shopId=" + shopId +
                ", staffCommissionRate=" + staffCommissionRate +
                '}';
    }
}
