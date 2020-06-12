package com.yingtongquan.employees.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStoreSumPo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStoreSumPo.*;

import java.util.List;

/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-06-10
*/
public interface TblShopGoodsSkuStoreSumService extends IService<TblShopGoodsSkuStoreSumPo> {

    Boolean addInfo(TblShopGoodsSkuStoreSumPoAddPa info);

    Boolean updateInfo(TblShopGoodsSkuStoreSumPoUpPa info);

    Boolean deleteByInfo(TblShopGoodsSkuStoreSumPoDelPa info);

    TblShopGoodsSkuStoreSumPo getByInfo(TblShopGoodsSkuStoreSumPoGetPa info);

    List<TblShopGoodsSkuStoreSumPo> getListByInfo(TblShopGoodsSkuStoreSumPoGetListPa info);

}
