package com.yingtongquan.employees.goods.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.*;
import com.yingtongquan.employees.goods.mapper.TblGoodsSkuMapper;
import com.yingtongquan.employees.goods.service.TblGoodsSkuService;
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
public class TblGoodsSkuServiceImpl extends ServiceImpl<TblGoodsSkuMapper, TblGoodsSkuPo> implements TblGoodsSkuService {

    @Resource
    private TblGoodsSkuMapper mapper;

    @Override
    public Boolean addInfo(TblGoodsSkuPoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblGoodsSkuPoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblGoodsSkuPoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblGoodsSkuPo getByInfo(TblGoodsSkuPoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblGoodsSkuPo> getListByInfo(TblGoodsSkuPoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
