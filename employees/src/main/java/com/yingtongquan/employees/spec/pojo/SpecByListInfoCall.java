package com.yingtongquan.employees.spec.pojo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author ML
 * @since 2020-05-14
 */
public class SpecByListInfoCall  implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer specNameId;
    private Integer fkShopId;
    private Long upTime;
    private String specNameName;
    private String specValueNames;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getSpecNameId() {
        return specNameId;
    }

    public void setSpecNameId(Integer specNameId) {
        this.specNameId = specNameId;
    }

    public Integer getFkShopId() {
        return fkShopId;
    }

    public void setFkShopId(Integer fkShopId) {
        this.fkShopId = fkShopId;
    }

    public String getSpecNameName() {
        return specNameName;
    }

    public void setSpecNameName(String specNameName) {
        this.specNameName = specNameName;
    }

    public String getSpecValueNames() {
        return specValueNames;
    }

    public void setSpecValueNames(String specValueNames) {
        this.specValueNames = specValueNames;
    }

    public Long getUpTime() {
        return upTime;
    }

    public void setUpTime(Long upTime) {
        this.upTime = upTime;
    }
}
