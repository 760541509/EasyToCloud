package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsPo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsPo.*;
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
public interface TblWarehouseGoodsMapper extends BaseMapper<TblWarehouseGoodsPo> {

    Boolean addInfo(TblWarehouseGoodsPoAddPa info);

    Boolean addBatchInfo(List<TblWarehouseGoodsPoAddPa> info);

    Boolean updateInfo(TblWarehouseGoodsPoUpPa info);

    Boolean deleteByInfo(TblWarehouseGoodsPoDelPa info);

    TblWarehouseGoodsPo getByInfo(TblWarehouseGoodsPoGetPa info);

    List<TblWarehouseGoodsPo> getListByInfo(TblWarehouseGoodsPoGetListPa info);

}
