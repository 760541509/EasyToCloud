package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-29
*/
@Mapper
@Repository
public interface TblGoodsSpuUnitMapper extends BaseMapper<TblGoodsSpuUnitPo> {

    Boolean addInfo(TblGoodsSpuUnitPoAddPa info);

    Boolean addBatchInfo(List<TblGoodsSpuUnitPoAddPa> info);

    Boolean updateInfo(TblGoodsSpuUnitPoUpPa info);

    Boolean deleteByInfo(TblGoodsSpuUnitPoDelPa info);

    TblGoodsSpuUnitPo getByInfo(TblGoodsSpuUnitPoGetPa info);

    List<TblGoodsSpuUnitPo> getListByInfo(TblGoodsSpuUnitPoGetListPa info);

}
