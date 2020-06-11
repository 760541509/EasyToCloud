package com.yingtongquan.employees.warehouse.service.impl;

import com.yingtongquan.employees.warehouse.entity.TblWarehouseAndShopPo;
import com.yingtongquan.employees.warehouse.mapper.TblWarehouseAndShopMapper;
import com.yingtongquan.employees.warehouse.service.TblWarehouseAndShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblWarehouseAndShopServiceImpl extends ServiceImpl<TblWarehouseAndShopMapper, TblWarehouseAndShopPo> implements TblWarehouseAndShopService {

    @Resource
    private TblWarehouseAndShopMapper warehouseAndShopMapper;

    @Override
    public Boolean addWarehouseAndShopRelationshipBetween(TblWarehouseAndShopPo warehouseAndShopPo) {
        return warehouseAndShopMapper.addWarehouseAndShopRelationshipBetween(warehouseAndShopPo);
    }

    @Override
    public void deleteWarehouseAndShopRelationshipBetween(TblWarehouseAndShopPo warehouseAndShopPo) {
        warehouseAndShopMapper.deleteWarehouseAndShopRelationshipBetween(warehouseAndShopPo);
    }
}
