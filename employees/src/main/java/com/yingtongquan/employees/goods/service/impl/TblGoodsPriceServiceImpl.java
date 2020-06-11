package com.yingtongquan.employees.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.TblGoodsPricePo;
import com.yingtongquan.employees.goods.entity.TblGoodsPricePo.*;
import com.yingtongquan.employees.goods.mapper.TblGoodsPriceMapper;
import com.yingtongquan.employees.goods.service.TblGoodsPriceService;
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
public class TblGoodsPriceServiceImpl extends ServiceImpl<TblGoodsPriceMapper, TblGoodsPricePo> implements TblGoodsPriceService {

    @Resource
    private TblGoodsPriceMapper mapper;

    @Override
    public Boolean addInfo(TblGoodsPricePoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblGoodsPricePoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblGoodsPricePoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblGoodsPricePo getByInfo(TblGoodsPricePoGetPa info){

        return mapper.getByInfo(info);
    }


    @Override
    public List<TblGoodsPricePo> getListByInfo(TblGoodsPricePoGetListPa info){

        return mapper.getListByInfo(info);
    }



}
