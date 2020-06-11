package com.yingtongquan.employees.goods.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.goods.entity.TblGoodsPricePo;
import com.yingtongquan.employees.goods.entity.TblGoodsPricePo.*;

import java.util.List;
/**
* <p>
*  服务类
* </p>
*
* @author ML
* @since 2020-05-29
*/
public interface TblGoodsPriceService extends IService<TblGoodsPricePo> {

    Boolean addInfo(TblGoodsPricePoAddPa info);

    Boolean updateInfo(TblGoodsPricePoUpPa info);

    Boolean deleteByInfo(TblGoodsPricePoDelPa info);

    TblGoodsPricePo getByInfo(TblGoodsPricePoGetPa info);


    List<TblGoodsPricePo> getListByInfo(TblGoodsPricePoGetListPa info);

}
