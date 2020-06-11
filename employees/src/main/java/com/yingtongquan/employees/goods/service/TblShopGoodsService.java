package com.yingtongquan.employees.goods.service;

import com.yingtongquan.employees.goods.entity.TblShopGoodsPo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoAddPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoUpPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoDelPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoGetPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoGetListPa;
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
public interface TblShopGoodsService extends IService<TblShopGoodsPo> {

    Boolean addInfo(TblShopGoodsPoAddPa info);

    Boolean updateInfo(TblShopGoodsPoUpPa info);

    Boolean deleteByInfo(TblShopGoodsPoDelPa info);

    TblShopGoodsPo getByInfo(TblShopGoodsPoGetPa info);

    List<TblShopGoodsPo> getListByInfo(TblShopGoodsPoGetListPa info);

}
