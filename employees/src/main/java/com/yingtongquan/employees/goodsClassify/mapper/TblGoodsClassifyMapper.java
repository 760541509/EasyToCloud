package com.yingtongquan.employees.goodsClassify.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo;
import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo.*;
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
public interface TblGoodsClassifyMapper extends BaseMapper<TblGoodsClassifyPo> {

    Boolean addInfo(TblGoodsClassifyPoAddPa info);

    Boolean addBatchInfo(List<TblGoodsClassifyPoAddPa> info);

    Boolean updateInfo(TblGoodsClassifyPoUpPa info);

    Boolean deleteByInfo(TblGoodsClassifyPoDelPa info);

    TblGoodsClassifyPo getByInfo(TblGoodsClassifyPoGetPa info);

    List<TblGoodsClassifyPo> getListByInfo(TblGoodsClassifyPoGetListPa info);

    List<TblGoodsClassifyPo> getListPrimaryClassification();

    List<TblGoodsClassifyPo> getListSecondClassification(Integer primaryId);

    List<TblGoodsClassifyPo> getListThreeClassification(List<Integer> secondIdList);

}
