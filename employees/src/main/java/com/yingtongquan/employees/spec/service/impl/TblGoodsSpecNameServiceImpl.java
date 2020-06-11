package com.yingtongquan.employees.spec.service.impl;


import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.spec.entity.TblGoodsSpecNamePo;
import com.yingtongquan.employees.spec.entity.TblGoodsSpecValuePo;
import com.yingtongquan.employees.spec.mapper.TblGoodsSpecNameMapper;
import com.yingtongquan.employees.spec.mapper.TblGoodsSpecValueMapper;
import com.yingtongquan.employees.spec.pojo.SpecByListInfoCall;
import com.yingtongquan.employees.spec.pojo.SpecByListInfoVo;
import com.yingtongquan.employees.spec.service.TblGoodsSpecNameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author ML
* @since 2020-05-14
*/
@Service
public class TblGoodsSpecNameServiceImpl extends ServiceImpl<TblGoodsSpecNameMapper, TblGoodsSpecNamePo> implements TblGoodsSpecNameService {

    @Resource
    private HttpServletRequest request;
    @Resource
    private TblGoodsSpecNameMapper mapper;
    @Resource
    private TblGoodsSpecValueMapper tblGoodsSpecValueMapper;

    @Override
    public Boolean addInfo(TblGoodsSpecNamePo.TblGoodsSpecNamePoAddPa info){
        info.setFkShopId(1);
        Boolean isMapperAddInfo = false;
        try {
            info.setUpTime(System.currentTimeMillis());
            isMapperAddInfo = mapper.addInfo(info);
        }catch (Exception e){
            //查询是否存在
            TblGoodsSpecNamePo.TblGoodsSpecNamePoGetPa goodsSpecNamePoGetPa = new TblGoodsSpecNamePo.TblGoodsSpecNamePoGetPa();
            goodsSpecNamePoGetPa.setFkShopId(info.getFkShopId());
            goodsSpecNamePoGetPa.setName(info.getName());
            TblGoodsSpecNamePo goodsSpecNamePo = mapper.getByInfo(goodsSpecNamePoGetPa);
            if(goodsSpecNamePo!=null){
                isMapperAddInfo =true;
                info.setId(goodsSpecNamePo.getId());
            }
            e.printStackTrace();
        }
        //添加属性
        if(isMapperAddInfo){
            //查询是否已存在
            List<TblGoodsSpecValuePo> goodsSpecValuePoList = tblGoodsSpecValueMapper.getListByFkGoodsSpecNameId(info.getId());
            goodsSpecValuePoList.forEach(tblGoodsSpecValuePo -> {

                int isExistIndex = -1;
                for (int i = 0; i < info.getGoodsSpecValuePoAddPaList().size(); i++) {
                    TblGoodsSpecValuePo.TblGoodsSpecValuePoAddPa tblGoodsSpecValuePoAddPa = info.getGoodsSpecValuePoAddPaList().get(i);
                    tblGoodsSpecValuePoAddPa.setFkGoodsSpecNameId(info.getId());
                    if(tblGoodsSpecValuePo.getName().equals(tblGoodsSpecValuePoAddPa.getName())){
                        isExistIndex = i;
                        break;
                    }
                }
                if(isExistIndex!=-1){
                    info.getGoodsSpecValuePoAddPaList().remove(isExistIndex);
                }
            });
            if(goodsSpecValuePoList.isEmpty()){
                info.getGoodsSpecValuePoAddPaList().forEach(tblGoodsSpecValuePoAddPa -> tblGoodsSpecValuePoAddPa.setFkGoodsSpecNameId(info.getId()));
            }
            if(info.getGoodsSpecValuePoAddPaList().isEmpty()){
                throw new IllegalArgumentException(StrUtil.format("该规格下,已存在相同的属性。"));
            }
            try {
                tblGoodsSpecValueMapper.addBatchInfo(info.getGoodsSpecValuePoAddPaList());
            }catch (Exception e){
                e.printStackTrace();
                throw new IllegalArgumentException(StrUtil.format("规格下,不允许有相同的属性。"));
            }

        }
        return isMapperAddInfo;
    }

    @Override
    public Boolean updateInfo(Map<String ,Object> info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(Map<String ,Object> info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblGoodsSpecNamePo getByInfo(TblGoodsSpecNamePo.TblGoodsSpecNamePoGetPa info){
        info.setFkShopId(1);
        TblGoodsSpecNamePo goodsSpecNamePo = mapper.getByInfo(info);

        if(goodsSpecNamePo!=null){
            //查找规格值
            List<TblGoodsSpecValuePo> goodsSpecValuePoList =  tblGoodsSpecValueMapper.getListByFkGoodsSpecNameId(goodsSpecNamePo.getId());
            goodsSpecNamePo.setGoodsSpecValuePoList(goodsSpecValuePoList);
        }

        return goodsSpecNamePo;
    }

    @Override
    public List<SpecByListInfoCall> getListByInfo(SpecByListInfoVo info){
        info.setFkShopId(1);
        return mapper.getListByInfo(info);
    }
}
