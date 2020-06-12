package com.yingtongquan.employees.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStoreSumPo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStoreSumPo.*;
import com.yingtongquan.employees.goods.mapper.TblShopGoodsSkuStoreSumMapper;
import com.yingtongquan.employees.goods.service.TblShopGoodsSkuStoreSumService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
* <p>
    *  服务实现类
    * </p>
*
* @author ML
* @since 2020-06-10
*/
@Service
public class TblShopGoodsSkuStoreSumServiceImpl extends ServiceImpl<TblShopGoodsSkuStoreSumMapper, TblShopGoodsSkuStoreSumPo> implements TblShopGoodsSkuStoreSumService {

    @Resource
    private TblShopGoodsSkuStoreSumMapper mapper;

    @Override
    public Boolean addInfo(TblShopGoodsSkuStoreSumPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblShopGoodsSkuStoreSumPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblShopGoodsSkuStoreSumPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblShopGoodsSkuStoreSumPo getByInfo(TblShopGoodsSkuStoreSumPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblShopGoodsSkuStoreSumPo> getListByInfo(TblShopGoodsSkuStoreSumPoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
