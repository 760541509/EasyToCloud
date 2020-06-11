package com.yingtongquan.employees.goods.service;

import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoUpPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoDelPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoGetPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoGetListPa;
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
public interface TblShopGoodsSkuStoreService extends IService<TblShopGoodsSkuStorePo> {

    Boolean addInfo(TblShopGoodsSkuStorePoAddPa info);

    Boolean updateInfo(TblShopGoodsSkuStorePoUpPa info);

    Boolean deleteByInfo(TblShopGoodsSkuStorePoDelPa info);

    TblShopGoodsSkuStorePo getByInfo(TblShopGoodsSkuStorePoGetPa info);

    List<TblShopGoodsSkuStorePo> getListByInfo(TblShopGoodsSkuStorePoGetListPa info);

}
