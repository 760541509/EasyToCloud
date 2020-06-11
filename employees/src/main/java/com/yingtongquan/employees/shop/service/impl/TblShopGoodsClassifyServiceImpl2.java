package com.yingtongquan.employees.shop.service.impl;

import com.yingtongquan.employees.shop.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.shop.mapper.TblShopGoodsClassifyMapper2;
import com.yingtongquan.employees.shop.pojo.ShopGoodsClassify;
import com.yingtongquan.employees.shop.service.TblShopGoodsClassifyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblShopGoodsClassifyServiceImpl2 extends ServiceImpl<TblShopGoodsClassifyMapper2, TblShopGoodsClassifyPo> implements TblShopGoodsClassifyService {

    @Resource
    private TblShopGoodsClassifyMapper2 shopGoodsClassifyMapper;

    @Override
    public List<ShopGoodsClassify> queryShopAllGoodsInformation(Integer shopId) {
//        return shopGoodsClassifyMapper.queryShopAllGoodsInformation(shopId);
        return null;
    }

    @Override
    public Boolean addShopGoodsClassify(TblShopGoodsClassifyPo shopGoodsClassifyPo) {
        shopGoodsClassifyPo.setSortIndex(0);
//        return shopGoodsClassifyMapper.addShopGoodsClassify(shopGoodsClassifyPo);
        return null;
    }

    @Override
    public List<ShopGoodsClassify> queryAllOneLevelGoodsClassify(Integer shopId) {
//        return shopGoodsClassifyMapper.queryShopGoodsOneLevelClassify(0, shopId);
        return null;
    }

    @Override
    public List<ShopGoodsClassify> queryOneLevelSubclassGoodsClassify(Integer supId, Integer shopId) {
//        return shopGoodsClassifyMapper.queryShopGoodsOneLevelClassify(supId, shopId);
        return null;
    }

    @Override
    public Boolean deleteGoodsClassify(Integer classifyId) {
//        return shopGoodsClassifyMapper.deleteGoodsClassify(classifyId);
        return null;
    }

    @Override
    public Boolean updateGoodsClassify(ShopGoodsClassify shopGoodsClassify) {
//        return shopGoodsClassifyMapper.updateGoodsClassify(shopGoodsClassify);
        return null;
    }
}
