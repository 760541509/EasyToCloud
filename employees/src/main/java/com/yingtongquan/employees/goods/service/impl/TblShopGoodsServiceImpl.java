package com.yingtongquan.employees.goods.service.impl;

import com.yingtongquan.employees.goods.entity.TblShopGoodsPo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoAddPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoUpPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoDelPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoGetPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsPo.TblShopGoodsPoGetListPa;
import com.yingtongquan.employees.goods.mapper.TblShopGoodsMapper;
import com.yingtongquan.employees.goods.service.TblShopGoodsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
/**
* <p>
    *  服务实现类
    * </p>
*
* @author ML
* @since 2020-05-29
*/
@Service
public class TblShopGoodsServiceImpl extends ServiceImpl<TblShopGoodsMapper, TblShopGoodsPo> implements TblShopGoodsService {

    @Resource
    private TblShopGoodsMapper mapper;

    @Override
    public Boolean addInfo(TblShopGoodsPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblShopGoodsPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblShopGoodsPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblShopGoodsPo getByInfo(TblShopGoodsPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblShopGoodsPo> getListByInfo(TblShopGoodsPoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
