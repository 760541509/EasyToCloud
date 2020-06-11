package com.yingtongquan.startcommon.address.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.startcommon.address.entity.TblAreaPo;
import com.yingtongquan.startcommon.address.mapper.TblAreaMapper;
import com.yingtongquan.startcommon.address.pojo.Address;
import com.yingtongquan.startcommon.address.service.TblAreaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 地区码表 服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-11
 */
@Service
public class TblAreaServiceImpl extends ServiceImpl<TblAreaMapper, TblAreaPo> implements TblAreaService {

    @Resource
    private TblAreaMapper areaMapper;

    @Override
    public List<TblAreaPo> queryAllProvincial() {
        return areaMapper.queryAllProvincial();
    }

    @Override
    public List<TblAreaPo> queryAllCitiesBelowTheProvincialLevel(Integer parentId) {
        return areaMapper.queryAllCitiesBelowTheProvincialLevel(parentId);
    }

    @Override
    public List<TblAreaPo> queryAllDistrictsBelowCityLevel(Integer parentId) {
        return areaMapper.queryAllDistrictsBelowCityLevel(parentId);
    }

    @Override
    public Address queryCityAndProvincial(Integer areaId) {
        return areaMapper.queryCityAndProvincial(areaId);
    }
}
