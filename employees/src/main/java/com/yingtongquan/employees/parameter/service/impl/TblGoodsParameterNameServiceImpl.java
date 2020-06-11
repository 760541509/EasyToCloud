package com.yingtongquan.employees.parameter.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.parameter.entity.TblGoodsParameterNamePo;
import com.yingtongquan.employees.parameter.mapper.TblGoodsParameterNameMapper;
import com.yingtongquan.employees.parameter.service.TblGoodsParameterNameService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
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
public class TblGoodsParameterNameServiceImpl extends ServiceImpl<TblGoodsParameterNameMapper, TblGoodsParameterNamePo> implements TblGoodsParameterNameService {

    @Resource
    private TblGoodsParameterNameMapper mapper;

    @Override
    public Map<String ,Object> add(Map<String ,Object> info){

        Map<String ,Object> byInfo = new HashMap<>();
        byInfo.put("name",info.get("name"));

        try {
            Boolean isSuccessful = mapper.add(info);
        }catch (Exception e){
            e.printStackTrace();
        }
        return getByInfo(byInfo);
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
