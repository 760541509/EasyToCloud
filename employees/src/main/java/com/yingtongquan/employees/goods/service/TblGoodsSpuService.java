package com.yingtongquan.employees.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.goods.entity.*;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuPo.*;

import java.util.List;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-29
*/
public interface TblGoodsSpuService extends IService<TblGoodsSpuPo> {

    Boolean addInfo(TblGoodsSpuPoAddPa info);

    Boolean addShopGoodsSkuStore(List<TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa> info);

    Boolean addWarehouseGoodsSkuStore(List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> info);

    Boolean updateInfo(TblGoodsSpuPoUpPa info);

    Boolean deleteByInfo(TblGoodsSpuPoDelPa info);

    TblGoodsSpuPoCall getByInfo(TblGoodsSpuPoGetPa info);

    List<TblGoodsSkuPo> getSkuListByGoodsId(TblGoodsSpuPoGetPa info);

    List<TblGoodsSpuPoCallList> getListByInfo(TblGoodsSpuPoGetListPa info);

}
