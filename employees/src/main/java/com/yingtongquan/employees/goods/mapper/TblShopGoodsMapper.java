package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.*;
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
public interface TblShopGoodsMapper extends BaseMapper<TblShopGoodsPo> {

    Boolean addInfo(TblShopGoodsPoAddPa info);

    Boolean addBatchInfo(List<TblShopGoodsPoAddPa> info);

    Boolean updateInfo(TblShopGoodsPoUpPa info);

    Boolean deleteByInfo(TblShopGoodsPoDelPa info);

    TblShopGoodsPo getByInfo(TblShopGoodsPoGetPa info);

    List<TblShopGoodsPo> getListByInfo(TblShopGoodsPoGetListPa info);

}
