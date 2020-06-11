package com.yingtongquan.employees.parameter.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.parameter.entity.TblGoodsParameterNamePo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-14
*/
@Mapper
@Repository
public interface TblGoodsParameterNameMapper extends BaseMapper<TblGoodsParameterNamePo> {

    Boolean add(Map<String ,Object> info);

    Boolean updateInfo(Map<String ,Object> info);

    Boolean deleteByInfo(Map<String ,Object> info);

    Map<String ,Object> getByInfo(Map<String ,Object> info);

    List< Map <String ,Object>> getListByInfo(Map<String ,Object> info);

}
