package com.yingtongquan.employees.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuUnitPo.*;
import com.yingtongquan.employees.goods.mapper.TblGoodsSpuUnitMapper;
import com.yingtongquan.employees.goods.service.TblGoodsSpuUnitService;
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
public class TblGoodsSpuUnitServiceImpl extends ServiceImpl<TblGoodsSpuUnitMapper, TblGoodsSpuUnitPo> implements TblGoodsSpuUnitService {

    @Resource
    private TblGoodsSpuUnitMapper mapper;

    @Override
    public Boolean addInfo(TblGoodsSpuUnitPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblGoodsSpuUnitPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblGoodsSpuUnitPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblGoodsSpuUnitPo getByInfo(TblGoodsSpuUnitPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblGoodsSpuUnitPo> getListByInfo(TblGoodsSpuUnitPoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
