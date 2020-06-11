package com.yingtongquan.employees.goods.service;

import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoAddPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoUpPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoDelPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoGetPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoGetListPa;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.Map;
import java.util.List;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-30
*/
public interface TblGoodsSkuSpecValueService extends IService<TblGoodsSkuSpecValuePo> {

    Boolean addInfo(TblGoodsSkuSpecValuePoAddPa info);

    Boolean updateInfo(TblGoodsSkuSpecValuePoUpPa info);

    Boolean deleteByInfo(TblGoodsSkuSpecValuePoDelPa info);

    TblGoodsSkuSpecValuePo getByInfo(TblGoodsSkuSpecValuePoGetPa info);

    List<TblGoodsSkuSpecValuePo> getListByInfo(TblGoodsSkuSpecValuePoGetListPa info);

}
