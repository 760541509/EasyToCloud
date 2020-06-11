package com.yingtongquan.employees.spec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.spec.entity.TblGoodsSpecNamePo;
import com.yingtongquan.employees.spec.pojo.SpecByListInfoCall;
import com.yingtongquan.employees.spec.pojo.SpecByListInfoVo;

import java.util.List;
import java.util.Map;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-14
*/
public interface TblGoodsSpecNameService extends IService<TblGoodsSpecNamePo> {

    Boolean addInfo(TblGoodsSpecNamePo.TblGoodsSpecNamePoAddPa info);

    Boolean updateInfo(Map<String ,Object> info);

    Boolean deleteByInfo(Map<String ,Object> info);

    TblGoodsSpecNamePo getByInfo(TblGoodsSpecNamePo.TblGoodsSpecNamePoGetPa info);

    List<SpecByListInfoCall> getListByInfo(SpecByListInfoVo info);

}
