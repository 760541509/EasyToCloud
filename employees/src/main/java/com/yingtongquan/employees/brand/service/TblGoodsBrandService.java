package com.yingtongquan.employees.brand.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.brand.entity.TblGoodsBrandPo;
import com.yingtongquan.employees.brand.entity.TblGoodsBrandPo.*;

import java.util.List;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-23
*/
public interface TblGoodsBrandService extends IService<TblGoodsBrandPo> {

    Boolean addInfo(TblGoodsBrandPoAddPa info);

    Boolean updateInfo(TblGoodsBrandPoUpPa info);

    Boolean deleteByInfo(TblGoodsBrandPoDelPa info);

    TblGoodsBrandPo getByInfo(TblGoodsBrandPoGetPa info);

    List<TblGoodsBrandPo> getListByInfo(TblGoodsBrandPoGetListPa info);

}
