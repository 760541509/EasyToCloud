package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStoreSumPo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStoreSumPo.*;
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
public interface TblWarehouseGoodsSkuStoreSumMapper extends BaseMapper<TblWarehouseGoodsSkuStoreSumPo> {

    Boolean addInfo(TblWarehouseGoodsSkuStoreSumPoAddPa info);

    Boolean addBatchInfo(List<TblWarehouseGoodsSkuStoreSumPoAddPa> info);

    Boolean updateInfo(TblWarehouseGoodsSkuStoreSumPoUpPa info);

    Boolean updateStoreBatchInfo(List<TblWarehouseGoodsSkuStoreSumPoUpPa> info);

    Boolean deleteByInfo(TblWarehouseGoodsSkuStoreSumPoDelPa info);

    TblWarehouseGoodsSkuStoreSumPo getByInfo(TblWarehouseGoodsSkuStoreSumPoGetPa info);

    List<TblWarehouseGoodsSkuStoreSumPo> getListByInfo(TblWarehouseGoodsSkuStoreSumPoGetListPa info);

    List<TblWarehouseGoodsSkuStoreSumPo> getListByGoodsSkuIds(List<Integer> info,Integer fkWarehouseId);
}
