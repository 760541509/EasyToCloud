package com.yingtongquan.employees.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.warehouse.entity.TblWarehouseGoodsAreaPo;
import com.yingtongquan.employees.warehouse.mapper.TblWarehouseGoodsAreaMapper;
import com.yingtongquan.employees.warehouse.pojo.WarehouseArea;
import com.yingtongquan.employees.warehouse.service.TblWarehouseGoodsAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblWarehouseGoodsAreaServiceImpl extends ServiceImpl<TblWarehouseGoodsAreaMapper, TblWarehouseGoodsAreaPo> implements TblWarehouseGoodsAreaService {

    @Resource
    private TblWarehouseGoodsAreaMapper warehouseGoodsAreaMapper;

    @Override
    public Boolean addWarehouseGoodsArea(TblWarehouseGoodsAreaPo warehouseGoodsAreaPo) {
        return warehouseGoodsAreaMapper.addWarehouseGoodsArea(warehouseGoodsAreaPo);
    }

    @Override
    public Boolean deleteWarehouseGoodsArea(Integer warehouseId) {
        return warehouseGoodsAreaMapper.deleteWarehouseGoodsArea(warehouseId);
    }

    @Override
    public Boolean updateWarehouseGoodsArea(WarehouseArea warehouseArea) {
        return warehouseGoodsAreaMapper.updateWarehouseGoodsArea(warehouseArea);
    }

    @Override
    public List<WarehouseArea> queryAllWarehouseGoodsArea(Integer warehouseId) {
        return warehouseGoodsAreaMapper.queryAllWarehouseGoodsArea(warehouseId);
    }
}
