package com.yingtongquan.employees.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStoreSumPo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStoreSumPo.*;

import java.util.List;

/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-06-10
*/
public interface TblWarehouseGoodsSkuStoreSumService extends IService<TblWarehouseGoodsSkuStoreSumPo> {

    Boolean addInfo(TblWarehouseGoodsSkuStoreSumPoAddPa info);

    Boolean updateInfo(TblWarehouseGoodsSkuStoreSumPoUpPa info);

    Boolean deleteByInfo(TblWarehouseGoodsSkuStoreSumPoDelPa info);

    TblWarehouseGoodsSkuStoreSumPo getByInfo(TblWarehouseGoodsSkuStoreSumPoGetPa info);

    List<TblWarehouseGoodsSkuStoreSumPo> getListByInfo(TblWarehouseGoodsSkuStoreSumPoGetListPa info);



}
