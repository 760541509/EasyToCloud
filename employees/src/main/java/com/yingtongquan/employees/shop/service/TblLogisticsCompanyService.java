package com.yingtongquan.employees.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.shop.entity.TblLogisticsCompanyPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblLogisticsCompanyService extends IService<TblLogisticsCompanyPo> {

    /**
     * @Date 2020/5/23 14:02
     * @Author 胖
     * 添加店铺物流公司表
     **/
    Boolean addShopLogisticsCompany(TblLogisticsCompanyPo logisticsCompanyPo);

    /**
     * @Date 2020/5/23 14:05
     * @Author 胖
     * 删除店铺物流表
     **/
    Boolean deleteShopLogisticsCompany(Integer id);

    /**
     * @Date 2020/5/23 14:06
     * @Author 胖
     * 修改店铺物流表
     **/
    Boolean updateShopLogisticsCompany(TblLogisticsCompanyPo logisticsCompanyPo);

    /**
     * @Date 2020/5/23 14:06
     * @Author 胖
     * 查询店铺物流表
     **/
    List<TblLogisticsCompanyPo> queryAllShopLogisticsCompany(Integer shopId);
}
