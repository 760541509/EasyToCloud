package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.*;
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
public interface TblGoodsSkuMapper extends BaseMapper<TblGoodsSkuPo> {

    Boolean addInfo(TblGoodsSkuPoAddPa info);

    Boolean addBatchInfo(List<TblGoodsSkuPoAddPa> info);

    Boolean updateInfo(TblGoodsSkuPoUpPa info);

    Boolean updateStoreBatchInfo(List<TblGoodsSkuPo> info);

    Boolean deleteByInfo(TblGoodsSkuPoDelPa info);

    TblGoodsSkuPo getByInfo(TblGoodsSkuPoGetPa info);

    List<TblGoodsSkuPo> getListByInfo(TblGoodsSkuPoGetListPa info);

    List<TblGoodsSkuPo> getListByGoodsIds(List<TblGoodsSpuPoCallList> info);

    List<TblGoodsSkuPo> getListByGoodsSkuIds(List<Integer> info);

    Integer countFkGoodsSpuId (Integer fkGoodsSpuId);

    Integer sumGoodsSkuStore (Integer fkGoodsSpuId);

}
