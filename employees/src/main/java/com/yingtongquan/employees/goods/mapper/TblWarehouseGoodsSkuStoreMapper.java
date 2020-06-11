package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.*;
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
public interface TblWarehouseGoodsSkuStoreMapper extends BaseMapper<TblWarehouseGoodsSkuStorePo> {

    Boolean addInfo(TblWarehouseGoodsSkuStorePoAddPa info);

    Boolean addBatchInfo(List<TblWarehouseGoodsSkuStorePoAddPa> info);

    Boolean updateInfo(TblWarehouseGoodsSkuStorePoUpPa info);

    Boolean deleteByInfo(TblWarehouseGoodsSkuStorePoDelPa info);

    TblWarehouseGoodsSkuStorePo getByInfo(TblWarehouseGoodsSkuStorePoGetPa info);

    List<TblWarehouseGoodsSkuStorePo> getListByInfo(TblWarehouseGoodsSkuStorePoGetListPa info);

}
