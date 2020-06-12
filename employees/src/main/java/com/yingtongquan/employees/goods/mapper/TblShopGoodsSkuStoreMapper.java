package com.yingtongquan.employees.goods.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.*;
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
public interface TblShopGoodsSkuStoreMapper extends BaseMapper<TblShopGoodsSkuStorePo> {

    Boolean addInfo(TblShopGoodsSkuStorePoAddPa info);

    Boolean addBatchInfo(List<TblShopGoodsSkuStorePoAddPa> info);

    Boolean updateInfo(TblShopGoodsSkuStorePoUpPa info);

    Boolean deleteByInfo(TblShopGoodsSkuStorePoDelPa info);

    TblShopGoodsSkuStorePo getByInfo(TblShopGoodsSkuStorePoGetPa info);

    List<TblShopGoodsSkuStorePo> getListByInfo(TblShopGoodsSkuStorePoGetListPa info);

}
