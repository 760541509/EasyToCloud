package com.yingtongquan.employees.goodsClassify.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo;
import com.yingtongquan.employees.goodsClassify.entity.TblGoodsClassifyPo.*;
import com.yingtongquan.employees.goodsClassify.mapper.TblGoodsClassifyMapper;
import com.yingtongquan.employees.goodsClassify.service.TblGoodsClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* <p>
    *  服务实现类
    * </p>
*
* @author ML
* @since 2020-05-27
*/
@Service
public class TblGoodsClassifyServiceImpl extends ServiceImpl<TblGoodsClassifyMapper, TblGoodsClassifyPo> implements TblGoodsClassifyService {

    @Resource
    private TblGoodsClassifyMapper mapper;

    @Override
    public Boolean addInfo(TblGoodsClassifyPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblGoodsClassifyPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblGoodsClassifyPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblGoodsClassifyPo getByInfo(TblGoodsClassifyPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblGoodsClassifyPo> getListByInfo(TblGoodsClassifyPoGetListPa info){

        return mapper.getListByInfo(info);
    }

    @Override
    public List<TblGoodsClassifyPo> getListPrimaryClassification() {
        return mapper.getListPrimaryClassification();
    }

    @Override
    public List<TblGoodsClassifyPo> getListSecondClassification(Integer primaryId) {
        return mapper.getListSecondClassification(primaryId);
    }

    @Override
    public List<TblGoodsClassifyPo> getListThreeClassification(List<Integer> secondIdList) {
        return mapper.getListThreeClassification(secondIdList);
    }

}
