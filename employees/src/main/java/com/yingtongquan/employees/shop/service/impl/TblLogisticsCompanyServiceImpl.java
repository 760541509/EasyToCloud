package com.yingtongquan.employees.shop.service.impl;

import com.yingtongquan.employees.shop.entity.TblLogisticsCompanyPo;
import com.yingtongquan.employees.shop.mapper.TblLogisticsCompanyMapper;
import com.yingtongquan.employees.shop.service.TblLogisticsCompanyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblLogisticsCompanyServiceImpl extends ServiceImpl<TblLogisticsCompanyMapper, TblLogisticsCompanyPo> implements TblLogisticsCompanyService {

    @Resource
    private TblLogisticsCompanyMapper logisticsCompanyMapper;

    @Override
    public Boolean addShopLogisticsCompany(TblLogisticsCompanyPo logisticsCompanyPo) {
        return logisticsCompanyMapper.addShopLogisticsCompany(logisticsCompanyPo);
    }

    @Override
    public Boolean deleteShopLogisticsCompany(Integer id) {
        return logisticsCompanyMapper.deleteShopLogisticsCompany(id);
    }

    @Override
    public Boolean updateShopLogisticsCompany(TblLogisticsCompanyPo logisticsCompanyPo) {
        return logisticsCompanyMapper.updateShopLogisticsCompany(logisticsCompanyPo);
    }

    @Override
    public List<TblLogisticsCompanyPo> queryAllShopLogisticsCompany(Integer shopId) {
        return logisticsCompanyMapper.queryAllShopLogisticsCompany(shopId);
    }
}
