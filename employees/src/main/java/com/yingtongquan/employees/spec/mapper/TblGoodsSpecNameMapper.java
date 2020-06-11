package com.yingtongquan.employees.spec.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.spec.entity.TblGoodsSpecNamePo;
import com.yingtongquan.employees.spec.pojo.SpecByListInfoCall;
import com.yingtongquan.employees.spec.pojo.SpecByListInfoVo;
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
public interface TblGoodsSpecNameMapper extends BaseMapper<TblGoodsSpecNamePo> {

    Boolean addInfo(TblGoodsSpecNamePo.TblGoodsSpecNamePoAddPa info);

    Boolean updateInfo(Map<String ,Object> info);

    Boolean deleteByInfo(Map<String ,Object> info);

    TblGoodsSpecNamePo getByInfo(TblGoodsSpecNamePo.TblGoodsSpecNamePoGetPa info);

    List<SpecByListInfoCall> getListByInfo(SpecByListInfoVo info);

}
