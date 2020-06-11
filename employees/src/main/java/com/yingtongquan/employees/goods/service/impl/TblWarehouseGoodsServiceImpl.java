package com.yingtongquan.employees.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.TblWarehouseGoodsPo;
import com.yingtongquan.employees.goods.mapper.TblWarehouseGoodsMapper;
import com.yingtongquan.employees.goods.service.TblWarehouseGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
/**
* <p>
    *  服务实现类
    * </p>
*
* @author ML
* @since 2020-05-29
*/
@Service
public class TblWarehouseGoodsServiceImpl extends ServiceImpl<TblWarehouseGoodsMapper, TblWarehouseGoodsPo> implements TblWarehouseGoodsService {

    @Resource
    private TblWarehouseGoodsMapper mapper;

    @Override
    public Boolean addInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblWarehouseGoodsPo getByInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblWarehouseGoodsPo> getListByInfo(TblWarehouseGoodsPo.TblWarehouseGoodsPoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
