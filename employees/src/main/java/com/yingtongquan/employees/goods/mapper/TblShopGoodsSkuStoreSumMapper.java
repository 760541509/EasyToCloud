package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStoreSumPo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStoreSumPo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-06-10
*/
@Mapper
@Repository
public interface TblShopGoodsSkuStoreSumMapper extends BaseMapper<TblShopGoodsSkuStoreSumPo> {

    Boolean addInfo(TblShopGoodsSkuStoreSumPoAddPa info);

    Boolean addBatchInfo(List<TblShopGoodsSkuStoreSumPoAddPa> info);

    Boolean updateInfo(TblShopGoodsSkuStoreSumPoUpPa info);

    Boolean updateStoreBatchInfo(List<TblShopGoodsSkuStoreSumPoUpPa> info);

    Boolean deleteByInfo(TblShopGoodsSkuStoreSumPoDelPa info);

    TblShopGoodsSkuStoreSumPo getByInfo(TblShopGoodsSkuStoreSumPoGetPa info);

    List<TblShopGoodsSkuStoreSumPo> getListByInfo(TblShopGoodsSkuStoreSumPoGetListPa info);

    List<TblShopGoodsSkuStoreSumPo> getListByGoodsSkuIds(List<Integer> info,Integer fkShopId);

}
