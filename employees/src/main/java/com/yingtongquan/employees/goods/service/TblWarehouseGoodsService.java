package com.yingtongquan.employees.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsPo;

import java.util.List;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-29
*/
public interface TblWarehouseGoodsService extends IService<TblWarehouseGoodsPo> {

    Boolean addInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoAddPa info);

    Boolean updateInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoUpPa info);

    Boolean deleteByInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoDelPa info);

    TblWarehouseGoodsPo getByInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoGetPa info);

    List<TblWarehouseGoodsPo> getListByInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoGetListPa info);

}
