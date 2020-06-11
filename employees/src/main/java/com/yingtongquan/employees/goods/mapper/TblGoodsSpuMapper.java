package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPoCallSpecDec;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuPo.*;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuPoCall;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuPoCallList;
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
public interface TblGoodsSpuMapper extends BaseMapper<TblGoodsSpuPo> {

    Boolean addInfo(TblGoodsSpuPoAddPa info);

    Boolean addBatchInfo(List<TblGoodsSpuPoAddPa> info);

    Boolean updateInfo(TblGoodsSpuPoUpPa info);

    Boolean deleteByInfo(TblGoodsSpuPoDelPa info);

    TblGoodsSpuPoCall getByInfo(TblGoodsSpuPoGetPa info);

    List<TblGoodsSpuPoCallList> getListByInfo(TblGoodsSpuPoGetListPa info);

    List<TblGoodsSkuPoCallSpecDec> getSpecDec (Integer fkGoodsSpuId);

}
