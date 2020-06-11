package com.yingtongquan.employees.warehouse.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.shop.entity.TblShopPo;
import com.yingtongquan.employees.warehouse.entity.TblWarehousePo;
import com.yingtongquan.employees.warehouse.pojo.ShopWarehouseGoodsArea;
import com.yingtongquan.employees.warehouse.pojo.WarehouseInformation;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblWarehouseService extends IService<TblWarehousePo> {

    /**
     * @Date 2020/5/21 15:54
     * @Author 胖
     * 创建仓库
     **/
    Boolean addShopExclusiveWarehouse(TblShopPo shopPo, WarehouseInformation warehouseInformation);

    /**
     * @Date 2020/5/23 14:21
     * @Author 胖
     * 查询所有的仓库
     **/
    List<ShopWarehouseGoodsArea> queryStoreAllWarehouse(Integer shopId);

    /**
     * @Date 2020/5/23 15:41
     * @Author 胖
     * 修改仓库信息
     **/
    Boolean updateShopWarehouse(ShopWarehouseGoodsArea warehouseGoodsArea);

    /**
     * @Date 2020/5/23 15:42
     * @Author 胖
     * 删除仓库
     **/
    String deleteShopWarehouse(Integer warehouseId, Integer shopId);


}
