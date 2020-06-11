package com.yingtongquan.employees.spec.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.spec.entity.TblGoodsSpecValuePo;

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
public interface TblGoodsSpecValueService extends IService<TblGoodsSpecValuePo> {

    Boolean add(Map<String ,Object> info);

    Boolean update(Map<String ,Object> info);

    Boolean deleteByInfo(Map<String ,Object> info);

    Map<String ,Object> getByInfo(Map<String ,Object> info);

    List< Map <String ,Object>> getListByInfo(Map<String ,Object> info);

}
