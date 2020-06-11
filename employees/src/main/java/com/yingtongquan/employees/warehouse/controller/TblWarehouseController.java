package com.yingtongquan.employees.warehouse.controller;


import com.yingtongquan.employees.shop.entity.TblShopPo;
import com.yingtongquan.employees.warehouse.entity.TblWarehouseGoodsAreaPo;
import com.yingtongquan.employees.warehouse.pojo.ShopWarehouseGoodsArea;
import com.yingtongquan.employees.warehouse.pojo.WarehouseInformation;
import com.yingtongquan.employees.warehouse.service.TblWarehouseGoodsAreaService;
import com.yingtongquan.employees.warehouse.service.TblWarehouseService;
import com.yingtongquan.startcommon.base.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@RestController
@RequestMapping("/warehouse/tblWarehousePo")
@Api(tags = "仓库相关操作")
public class TblWarehouseController {

    @Resource
    private RedisTemplate redisTemplate;
    @Resource
    private TblWarehouseGoodsAreaService warehouseGoodsAreaService;
    @Resource
    private TblWarehouseService warehouseService;

    @ApiOperation(value = "创建仓库")
    @PostMapping("/createAWarehouse")
    public ResultVo createAWarehouse(@RequestBody TblShopPo shopPo, @RequestBody WarehouseInformation warehouseInformation) {
        warehouseInformation.setDontAllow(1);
        return ResultVo.successResult(warehouseService.addShopExclusiveWarehouse(shopPo, warehouseInformation));
    }

    @ApiOperation(value = "查询所有的仓库")
    @PostMapping("/queryAllWarehouses")
    public ResultVo queryAllWarehouses(Integer shopId) {
        return ResultVo.successResult(warehouseService.queryStoreAllWarehouse(1));
    }

    @ApiOperation(value = "修改仓库信息")
    @PostMapping("/modifyTheWarehouseInformation")
    public ResultVo modifyTheWarehouseInformation(@RequestBody ShopWarehouseGoodsArea warehouseGoodsArea) {
        return ResultVo.successResult(warehouseService.updateShopWarehouse(warehouseGoodsArea));
    }

    @ApiOperation(value = "删除仓库")
    @PostMapping("/removeTheWarehouse")
    public ResultVo removeTheWarehouse(Integer warehouseId, Integer shopId) {
        return ResultVo.successResult(warehouseService.deleteShopWarehouse(warehouseId, shopId));
    }

    @ApiOperation(value = "添加仓库商品区域")
    @PostMapping("/addTheWarehouseMerchandiseArea")
    public ResultVo addTheWarehouseMerchandiseArea(@RequestBody TblWarehouseGoodsAreaPo warehouseGoodsAreaPo) {
        return ResultVo.successResult(warehouseGoodsAreaService.addWarehouseGoodsArea(warehouseGoodsAreaPo));
    }

    @ApiOperation(value = "删除仓库商品区域")
    @PostMapping("/deleteTheWarehouseMerchandiseArea")
    public ResultVo deleteTheWarehouseMerchandiseArea(Integer warehouseId) {
        return ResultVo.successResult(warehouseGoodsAreaService.deleteWarehouseGoodsArea(warehouseId));
    }

}
