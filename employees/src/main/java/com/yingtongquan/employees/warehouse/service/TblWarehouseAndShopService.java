package com.yingtongquan.employees.warehouse.service;

import com.yingtongquan.employees.warehouse.entity.TblWarehouseAndShopPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblWarehouseAndShopService extends IService<TblWarehouseAndShopPo> {

    /**
     * @Date 2020/5/23 15:07
     * @Author 胖
     * 添加关系表
     **/
    Boolean addWarehouseAndShopRelationshipBetween(TblWarehouseAndShopPo warehouseAndShopPo);

    /**
     * @Date 2020/5/23 17:04
     * @Author 胖
     * 删除关系表
     **/
    void deleteWarehouseAndShopRelationshipBetween(TblWarehouseAndShopPo warehouseAndShopPo);
}
