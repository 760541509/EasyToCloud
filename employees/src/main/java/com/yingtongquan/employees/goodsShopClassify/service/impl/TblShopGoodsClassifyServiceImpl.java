package com.yingtongquan.employees.goodsShopClassify.service.impl;

import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo.*;
import com.yingtongquan.employees.goodsShopClassify.mapper.TblShopGoodsClassifyMapper;
import com.yingtongquan.employees.goodsShopClassify.service.TblShopGoodsClassifyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class TblShopGoodsClassifyServiceImpl extends ServiceImpl<TblShopGoodsClassifyMapper, TblShopGoodsClassifyPo> implements TblShopGoodsClassifyService {

    @Resource
    private TblShopGoodsClassifyMapper mapper;

    @Override
    public Boolean addInfo(TblShopGoodsClassifyPoAddPa info){

        Boolean isMapperAddInfo = mapper.addInfo(info);
        //添加成功，并且有子分类
        if(isMapperAddInfo&&info.getChildList()!=null&&info.getChildList().size()>0){
            //添加二级分类
            info.getChildList().forEach(tblShopGoodsClassifyPo -> {
                tblShopGoodsClassifyPo.setSupId(info.getId());
                tblShopGoodsClassifyPo.setFkShopId(info.getFkShopId());
            });
            System.out.println("info.getChildList()===="+ JSONUtil.toJsonStr(info.getChildList()));
            Boolean isSecondAddBatch = mapper.addBatchInfo(info.getChildList());
            //添加三级分类
            if(isSecondAddBatch){
                List<TblShopGoodsClassifyPoAddPa> thirdList = new ArrayList<>();
                info.getChildList().forEach(tblShopGoodsClassifyPoAddPa -> {
                    tblShopGoodsClassifyPoAddPa.getChildList().forEach(tblShopGoodsClassifyPoAddPa1 -> {
                        tblShopGoodsClassifyPoAddPa1.setSupId(tblShopGoodsClassifyPoAddPa.getId());
                        tblShopGoodsClassifyPoAddPa1.setFkShopId(tblShopGoodsClassifyPoAddPa.getFkShopId());
                        thirdList.add(tblShopGoodsClassifyPoAddPa1);
                    });
                });
                System.out.println("thirdList===="+ JSONUtil.toJsonStr(thirdList));
                if(thirdList.size()>0){
                    Boolean isThirdAddBatch = mapper.addBatchInfo(thirdList);
                    if(!isThirdAddBatch){
                        throw new IllegalArgumentException(StrUtil.format("添加三级分类出错了.."));
                    }
                }

            }else {
                throw new IllegalArgumentException(StrUtil.format("添加二级分类出错了.."));
            }
        }

        return isMapperAddInfo;
    }

    @Override
    public Boolean updateInfo(TblShopGoodsClassifyPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblShopGoodsClassifyPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblShopGoodsClassifyPo getByInfo(TblShopGoodsClassifyPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblShopGoodsClassifyPo> getListByInfo(TblShopGoodsClassifyPoGetListPa info){

        return mapper.getListByInfo(info);
    }

    @Override
    public List<TblShopGoodsClassifyPo> getListPrimaryClassification(Integer fkShopId) {
        return mapper.getListPrimaryClassification(fkShopId);
    }

    @Override
    public List<TblShopGoodsClassifyPo> getListSecondClassification(Integer primaryId) {
        return mapper.getListSecondClassification(primaryId);
    }

    @Override
    public List<TblShopGoodsClassifyPo> getListThreeClassification(List<Integer> secondIdList) {
        return mapper.getListThreeClassification(secondIdList);
    }
}
