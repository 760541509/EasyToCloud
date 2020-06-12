package com.yingtongquan.employees.goods.service.impl;

import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoAddPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoUpPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoDelPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoGetPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuPo.TblGoodsSkuPoGetListPa;
import com.yingtongquan.employees.goods.mapper.TblGoodsSkuMapper;
import com.yingtongquan.employees.goods.service.TblGoodsSkuService;
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
