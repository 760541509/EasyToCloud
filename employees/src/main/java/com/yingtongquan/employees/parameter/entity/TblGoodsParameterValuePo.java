package com.yingtongquan.employees.parameter.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ML
 * @since 2020-05-14
 */
@TableName("tbl_goods_parameter_value")
public class TblGoodsParameterValuePo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 参数的值
     */
    private String name;

    /**
     * 参数名称的id
     */
    private Integer fkGoodsParameterId;

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
    public Integer getFkGoodsParameterId() {
        return fkGoodsParameterId;
    }

    public void setFkGoodsParameterId(Integer fkGoodsParameterId) {
        this.fkGoodsParameterId = fkGoodsParameterId;
    }

    @Override
    public String toString() {
        return "TblGoodsParameterValuePo{" +
        "id=" + id +
        ", name=" + name +
        ", fkGoodsParameterId=" + fkGoodsParameterId +
        "}";
    }
}
