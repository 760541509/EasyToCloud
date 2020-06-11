package com.yingtongquan.employees.goodsClassify.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo;
import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo.*;

import java.util.List;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-27
*/
public interface TblGoodsClassifyService extends IService<TblGoodsClassifyPo> {

    Boolean addInfo(TblGoodsClassifyPoAddPa info);

    Boolean updateInfo(TblGoodsClassifyPoUpPa info);

    Boolean deleteByInfo(TblGoodsClassifyPoDelPa info);

    TblGoodsClassifyPo getByInfo(TblGoodsClassifyPoGetPa info);

    List<TblGoodsClassifyPo> getListByInfo(TblGoodsClassifyPoGetListPa info);

    List<TblGoodsClassifyPo> getListPrimaryClassification();

    List<TblGoodsClassifyPo> getListSecondClassification(Integer primaryId);

    List<TblGoodsClassifyPo> getListThreeClassification(List<Integer> secondIdList);

}
