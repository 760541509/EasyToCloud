package com.yingtongquan.employees.goodsShopClassify.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo.*;

import java.util.List;
/**
* <p>
    *  服务类
    * </p>
*
* @author ML
* @since 2020-05-27
*/
public interface TblShopGoodsClassifyService extends IService<TblShopGoodsClassifyPo> {

    Boolean addInfo(TblShopGoodsClassifyPoAddPa info);

    Boolean updateInfo(TblShopGoodsClassifyPoUpPa info);

    Boolean deleteByInfo(TblShopGoodsClassifyPoDelPa info);

    TblShopGoodsClassifyPo getByInfo(TblShopGoodsClassifyPoGetPa info);

    List<TblShopGoodsClassifyPo> getListByInfo(TblShopGoodsClassifyPoGetListPa info);

    List<TblShopGoodsClassifyPo> getListPrimaryClassification(Integer fkShopId);

    List<TblShopGoodsClassifyPo> getListSecondClassification(Integer primaryId);

    List<TblShopGoodsClassifyPo> getListThreeClassification(List<Integer> secondIdList);

}
