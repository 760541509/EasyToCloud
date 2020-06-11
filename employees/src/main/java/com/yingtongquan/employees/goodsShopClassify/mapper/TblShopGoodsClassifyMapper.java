package com.yingtongquan.employees.goodsShopClassify.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-27
*/
@Mapper
@Repository
public interface TblShopGoodsClassifyMapper extends BaseMapper<TblShopGoodsClassifyPo> {

    Boolean addInfo(TblShopGoodsClassifyPoAddPa info);

    Boolean addBatchInfo(List<TblShopGoodsClassifyPoAddPa> info);

    Boolean updateInfo(TblShopGoodsClassifyPoUpPa info);

    Boolean deleteByInfo(TblShopGoodsClassifyPoDelPa info);

    TblShopGoodsClassifyPo getByInfo(TblShopGoodsClassifyPoGetPa info);

    List<TblShopGoodsClassifyPo> getListByInfo(TblShopGoodsClassifyPoGetListPa info);

    List<TblShopGoodsClassifyPo> getListPrimaryClassification(Integer fkShopId);

    List<TblShopGoodsClassifyPo> getListSecondClassification(Integer primaryId);

    List<TblShopGoodsClassifyPo> getListThreeClassification(List<Integer> secondIdList);

}
