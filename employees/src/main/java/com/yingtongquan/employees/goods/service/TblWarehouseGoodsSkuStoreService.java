package com.yingtongquan.employees.goods.service;

import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoUpPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoDelPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoGetPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoGetListPa;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;
import java.util.List;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-29
*/
public interface TblWarehouseGoodsSkuStoreService extends IService<TblWarehouseGoodsSkuStorePo> {

    Boolean addInfo(TblWarehouseGoodsSkuStorePoAddPa info);

    Boolean updateInfo(TblWarehouseGoodsSkuStorePoUpPa info);

    Boolean deleteByInfo(TblWarehouseGoodsSkuStorePoDelPa info);

    TblWarehouseGoodsSkuStorePo getByInfo(TblWarehouseGoodsSkuStorePoGetPa info);

    List<TblWarehouseGoodsSkuStorePo> getListByInfo(TblWarehouseGoodsSkuStorePoGetListPa info);

}
