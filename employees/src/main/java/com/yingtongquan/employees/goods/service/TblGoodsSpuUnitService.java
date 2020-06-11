package com.yingtongquan.employees.goods.service;

import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo.TblGoodsSpuUnitPoAddPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo.TblGoodsSpuUnitPoUpPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo.TblGoodsSpuUnitPoDelPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo.TblGoodsSpuUnitPoGetPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo.TblGoodsSpuUnitPoGetListPa;
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
public interface TblGoodsSpuUnitService extends IService<TblGoodsSpuUnitPo> {

    Boolean addInfo(TblGoodsSpuUnitPoAddPa info);

    Boolean updateInfo(TblGoodsSpuUnitPoUpPa info);

    Boolean deleteByInfo(TblGoodsSpuUnitPoDelPa info);

    TblGoodsSpuUnitPo getByInfo(TblGoodsSpuUnitPoGetPa info);

    List<TblGoodsSpuUnitPo> getListByInfo(TblGoodsSpuUnitPoGetListPa info);

}
