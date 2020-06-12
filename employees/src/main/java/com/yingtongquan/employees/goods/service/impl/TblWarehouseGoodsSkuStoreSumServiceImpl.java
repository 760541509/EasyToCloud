package com.yingtongquan.employees.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStoreSumPo;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsSkuStoreSumPo.*;
import com.yingtongquan.employees.goods.mapper.TblWarehouseGoodsSkuStoreSumMapper;
import com.yingtongquan.employees.goods.service.TblWarehouseGoodsSkuStoreSumService;
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
public class TblWarehouseGoodsSkuStoreSumServiceImpl extends ServiceImpl<TblWarehouseGoodsSkuStoreSumMapper, TblWarehouseGoodsSkuStoreSumPo> implements TblWarehouseGoodsSkuStoreSumService {

    @Resource
    private TblWarehouseGoodsSkuStoreSumMapper mapper;

    @Override
    public Boolean addInfo(TblWarehouseGoodsSkuStoreSumPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblWarehouseGoodsSkuStoreSumPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblWarehouseGoodsSkuStoreSumPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblWarehouseGoodsSkuStoreSumPo getByInfo(TblWarehouseGoodsSkuStoreSumPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblWarehouseGoodsSkuStoreSumPo> getListByInfo(TblWarehouseGoodsSkuStoreSumPoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
