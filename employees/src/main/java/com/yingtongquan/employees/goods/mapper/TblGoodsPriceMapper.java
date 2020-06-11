package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblGoodsPricePo;
import com.yingtongquan.employees.goods.entity.TblGoodsPricePo.*;
import com.yingtongquan.employees.goods.pojo.GoodsPricePoCallClient;
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
public interface TblGoodsPriceMapper extends BaseMapper<TblGoodsPricePo> {

    Boolean addInfo(TblGoodsPricePo.TblGoodsPricePoAddPa info);

    Boolean addBatchInfo(List<TblGoodsPricePoAddPa> info);

    Boolean updateInfo(TblGoodsPricePoUpPa info);

    Boolean deleteByInfo(TblGoodsPricePoDelPa info);

    TblGoodsPricePo getByInfo(TblGoodsPricePoGetPa info);

    Integer getDefaFkMemberPriceShopId(Integer shopId);

    List<TblGoodsPricePo> getListByInfo(TblGoodsPricePoGetListPa info);

    GoodsPricePoCallClient getPriceRangeByInfo(TblGoodsPricePoGetPa info);
}
