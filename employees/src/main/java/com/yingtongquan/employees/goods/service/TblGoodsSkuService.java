package com.yingtongquan.employees.goods.service;

import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoAddPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoUpPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoDelPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoGetPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoGetListPa;
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
public interface TblGoodsSkuService extends IService<TblGoodsSkuPo> {

    Boolean addInfo(TblGoodsSkuPoAddPa info);

    Boolean updateInfo(TblGoodsSkuPoUpPa info);

    Boolean deleteByInfo(TblGoodsSkuPoDelPa info);

    TblGoodsSkuPo getByInfo(TblGoodsSkuPoGetPa info);

    List<TblGoodsSkuPo> getListByInfo(TblGoodsSkuPoGetListPa info);

}
