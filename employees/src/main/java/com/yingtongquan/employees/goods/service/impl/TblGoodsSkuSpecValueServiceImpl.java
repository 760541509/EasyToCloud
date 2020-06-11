package com.yingtongquan.employees.goods.service.impl;

import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoAddPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoUpPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoDelPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoGetPa;
import com.yingtongquan.employees.goods.entity.TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoGetListPa;
import com.yingtongquan.employees.goods.mapper.TblGoodsSkuSpecValueMapper;
import com.yingtongquan.employees.goods.service.TblGoodsSkuSpecValueService;
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
* @since 2020-05-30
*/
@Service
public class TblGoodsSkuSpecValueServiceImpl extends ServiceImpl<TblGoodsSkuSpecValueMapper, TblGoodsSkuSpecValuePo> implements TblGoodsSkuSpecValueService {

    @Resource
    private TblGoodsSkuSpecValueMapper mapper;

    @Override
    public Boolean addInfo(TblGoodsSkuSpecValuePoAddPa info){

        return mapper.addInfo(info);
    }

    @Override
    public Boolean updateInfo(TblGoodsSkuSpecValuePoUpPa info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblGoodsSkuSpecValuePoDelPa info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public TblGoodsSkuSpecValuePo getByInfo(TblGoodsSkuSpecValuePoGetPa info){

        return mapper.getByInfo(info);
    }

    @Override
    public List<TblGoodsSkuSpecValuePo> getListByInfo(TblGoodsSkuSpecValuePoGetListPa info){

        return mapper.getListByInfo(info);
    }
}
