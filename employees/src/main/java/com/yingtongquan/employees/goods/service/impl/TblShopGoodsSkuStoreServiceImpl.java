package com.yingtongquan.employees.goods.service.impl;

import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoUpPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoDelPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoGetPa;
import com.yingtongquan.employees.goods.entity.TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoGetListPa;
import com.yingtongquan.employees.goods.mapper.TblShopGoodsSkuStoreMapper;
import com.yingtongquan.employees.goods.service.TblShopGoodsSkuStoreService;
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
public class TblShopGoodsSkuStoreServiceImpl extends ServiceImpl<TblShopGoodsSkuStoreMapper, TblShopGoodsSkuStorePo> implements TblShopGoodsSkuStoreService {

    @Resource
    private TblShopGoodsSkuStoreMapper mapper;

    @Override
    public Boolean addInfo(TblShopGoodsSkuStorePoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblShopGoodsSkuStorePoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblShopGoodsSkuStorePoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblShopGoodsSkuStorePo getByInfo(TblShopGoodsSkuStorePoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblShopGoodsSkuStorePo> getListByInfo(TblShopGoodsSkuStorePoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
