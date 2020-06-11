package com.yingtongquan.employees.spec.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.spec.entity.TblGoodsSpecValuePo;
import com.yingtongquan.employees.spec.mapper.TblGoodsSpecValueMapper;
import com.yingtongquan.employees.spec.service.TblGoodsSpecValueService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
/**
* <p>
    *  服务实现类
    * </p>
*
* @author ML
* @since 2020-05-14
*/
@Service
public class TblGoodsSpecValueServiceImpl extends ServiceImpl<TblGoodsSpecValueMapper, TblGoodsSpecValuePo> implements TblGoodsSpecValueService {

    @Resource
    private TblGoodsSpecValueMapper mapper;

    @Override
    public Boolean add(Map<String ,Object> info){

        return mapper.add(info);
    }

    @Override
    public Boolean update(Map<String ,Object> info){

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(Map<String ,Object> info){

        return mapper.deleteByInfo(info);
    }

    @Override
    public Map<String ,Object> getByInfo(Map<String ,Object> info){

        return mapper.getByInfo(info);
    }

    @Override
    public List< Map <String ,Object>> getListByInfo(Map<String ,Object> info){

        return mapper.getListByInfo(info);
    }
}
