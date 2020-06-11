package com.yingtongquan.employees.warehouse.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.shop.entity.TblShopPo;
import com.yingtongquan.employees.shop.mapper.TblShopMapper;
import com.yingtongquan.employees.warehouse.entity.TblWarehouseAndShopPo;
import com.yingtongquan.employees.warehouse.entity.TblWarehousePo;
import com.yingtongquan.employees.warehouse.mapper.TblWarehouseMapper;
import com.yingtongquan.employees.warehouse.pojo.ShopWarehouseGoodsArea;
import com.yingtongquan.employees.warehouse.pojo.WarehouseArea;
import com.yingtongquan.employees.warehouse.pojo.WarehouseInformation;
import com.yingtongquan.employees.warehouse.service.TblWarehouseAndShopService;
import com.yingtongquan.employees.warehouse.service.TblWarehouseGoodsAreaService;
import com.yingtongquan.employees.warehouse.service.TblWarehouseService;
import com.yingtongquan.startcommon.address.pojo.Address;
import com.yingtongquan.startcommon.address.pojo.Coordinate;
import com.yingtongquan.startcommon.util.AddressUtil;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
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
public class TblWarehouseServiceImpl extends ServiceImpl<TblWarehouseMapper, TblWarehousePo> implements TblWarehouseService {

    @Resource
    private HttpServletRequest request;
    @Resource
    private TblShopMapper shopMapper;
    @Resource
    private TblWarehouseMapper warehouseMapper;
    @Resource
    private TblWarehouseAndShopService warehouseAndShopService;
    @Resource
    private TblWarehouseGoodsAreaService warehouseGoodsAreaService;

    @Override
    public Boolean addShopExclusiveWarehouse(TblShopPo shopPo, WarehouseInformation warehouseInformation) {
        TblWarehousePo warehousePo = new TblWarehousePo();
        warehousePo.setAddress(shopPo.getAddress());
        warehousePo.setAddTime(System.currentTimeMillis());
        warehousePo.setAreaId(shopPo.getAreaId());
        warehousePo.setLatitude(shopPo.getLatitude());
        warehousePo.setLongitude(shopPo.getLongitude());
        warehousePo.setPhone(shopPo.getPhone());
        warehousePo.setTelephone(shopPo.getTelephone());
        warehousePo.setUserId(shopPo.getUserId());
        warehousePo.setWarehouseName(warehouseInformation.getWarehouseName());
        warehousePo.setDontAllow(warehouseInformation.getDontAllow());
        warehouseMapper.addShopWarehouse(warehousePo);

        TblWarehouseAndShopPo warehouseAndShopPo = new TblWarehouseAndShopPo();
        warehouseAndShopPo.setShopId(shopPo.getId());
        warehouseAndShopPo.setWarehouseId(warehousePo.getId());
        return warehouseAndShopService.addWarehouseAndShopRelationshipBetween(warehouseAndShopPo);
    }

    @Override
    public List<ShopWarehouseGoodsArea> queryStoreAllWarehouse(Integer shopId) {

        List<ShopWarehouseGoodsArea> shopWarehouseGoodsAreas = warehouseMapper.queryShopAllWarehouse(shopId);
        for (ShopWarehouseGoodsArea shopWarehouseGoodsArea : shopWarehouseGoodsAreas) {
            shopWarehouseGoodsArea.setWarehouseAreas(warehouseGoodsAreaService.queryAllWarehouseGoodsArea(shopWarehouseGoodsArea.getWarehouseId()));
        }

        return shopWarehouseGoodsAreas;
    }

    @Override
    public Boolean updateShopWarehouse(ShopWarehouseGoodsArea warehouseGoodsArea) {
        for (WarehouseArea warehouseArea : warehouseGoodsArea.getWarehouseAreas()) {
            warehouseGoodsAreaService.updateWarehouseGoodsArea(warehouseArea);
        }
        Address address = shopMapper.queryCityAndProvincial(warehouseGoodsArea.getAreaId());
        String detailedAddress = address.getProvince() + address.getCity() + address.getArea() + warehouseGoodsArea.getAddress();
        Coordinate coordinate = AddressUtil.coordinate(detailedAddress);
        TblWarehousePo warehousePo = new TblWarehousePo();
        warehousePo.setAddress(warehouseGoodsArea.getAddress());
        warehousePo.setWarehouseName(warehouseGoodsArea.getWarehouseName());
        warehousePo.setTelephone(warehouseGoodsArea.getTelephone());
        warehousePo.setPhone(warehouseGoodsArea.getPhone());
        warehousePo.setAreaId(warehouseGoodsArea.getAreaId());
        warehousePo.setAddress(warehouseGoodsArea.getAddress());
        warehousePo.setLatitude(coordinate.getLatitude());
        warehousePo.setLongitude(coordinate.getLongitude());
        warehousePo.setId(warehouseGoodsArea.getWarehouseId());
        return warehouseMapper.updateShopWarehouse(warehousePo);
    }

    @Override
    public String deleteShopWarehouse(Integer warehouseId, Integer shopId) {
        String token = request.getHeader("token");
        Integer curUserId = HttpUtil.getCurUserId(token);
        TblWarehousePo warehousePo = warehouseMapper.queryWarehouseInformation(warehouseId);
        if (warehousePo.getUserId().equals(curUserId)) {
            Boolean warehouse = warehouseMapper.deleteShopWarehouse(warehouseId);
            if (warehouse) {
                TblWarehouseAndShopPo warehouseAndShopPo = new TblWarehouseAndShopPo();
                warehouseAndShopPo.setWarehouseId(warehousePo.getId());
                warehouseAndShopPo.setShopId(shopId);
                warehouseAndShopService.deleteWarehouseAndShopRelationshipBetween(warehouseAndShopPo);
                return "删除成功";
            } else {
                return "删除失败,默认仓库不能删除";
            }
        } else {
            return "你不是该仓库的创建者,请联系创建人删除或者联系客服人员";
        }
    }
}
