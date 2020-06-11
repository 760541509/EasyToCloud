package com.yingtongquan.employees.brand.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.brand.entity.TblGoodsBrandPo;
import com.yingtongquan.employees.brand.entity.TblGoodsBrandPo.*;
import com.yingtongquan.employees.brand.mapper.TblGoodsBrandMapper;
import com.yingtongquan.employees.brand.service.TblGoodsBrandService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* <p>
    *  服务实现类
    * </p>
*
* @author ML
* @since 2020-05-23
*/
@Service
public class TblGoodsBrandServiceImpl extends ServiceImpl<TblGoodsBrandMapper, TblGoodsBrandPo> implements TblGoodsBrandService {

    @Resource
    private TblGoodsBrandMapper mapper;

    @Override
    public Boolean addInfo(TblGoodsBrandPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblGoodsBrandPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblGoodsBrandPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblGoodsBrandPo getByInfo(TblGoodsBrandPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblGoodsBrandPo> getListByInfo(TblGoodsBrandPoGetListPa info){

        if(info.getFkShopId()==null){
            info.setFkShopId(1);
        }

        //查询平台全部商品品牌
        if(info.getFkShopId()==-1){
            return mapper.getListByInfo(info);
        }
        //查询门店id 的商品品牌
        else{
            return mapper.getListByShopId(info.getFkShopId());
        }

    }
}
