package com.yingtongquan.employees.goods.service.impl;

import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoUpPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoDelPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoGetPa;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoGetListPa;
import com.yingtongquan.employees.goods.mapper.TblWarehouseGoodsSkuStoreMapper;
import com.yingtongquan.employees.goods.service.TblWarehouseGoodsSkuStoreService;
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
public class TblWarehouseGoodsSkuStoreServiceImpl extends ServiceImpl<TblWarehouseGoodsSkuStoreMapper, TblWarehouseGoodsSkuStorePo> implements TblWarehouseGoodsSkuStoreService {

    @Resource
    private TblWarehouseGoodsSkuStoreMapper mapper;

    @Override
    public Boolean addInfo(TblWarehouseGoodsSkuStorePoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblWarehouseGoodsSkuStorePoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblWarehouseGoodsSkuStorePoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblWarehouseGoodsSkuStorePo getByInfo(TblWarehouseGoodsSkuStorePoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblWarehouseGoodsSkuStorePo> getListByInfo(TblWarehouseGoodsSkuStorePoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
