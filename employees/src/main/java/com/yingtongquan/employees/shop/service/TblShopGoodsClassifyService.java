package com.yingtongquan.employees.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.shop.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.shop.pojo.ShopGoodsClassify;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblShopGoodsClassifyService extends IService<TblShopGoodsClassifyPo> {

    /**
     * @Date 2020/5/22 14:46
     * @Author 胖
     * 查询店铺下所有的商品分类
     **/
    List<ShopGoodsClassify> queryShopAllGoodsInformation(Integer shopId);

    /**
     * @Date 2020/5/22 15:20
     * @Author 胖
     * 发布商品分类
     **/
    Boolean addShopGoodsClassify(TblShopGoodsClassifyPo shopGoodsClassifyPo);

    /**
     * @Date 2020/5/22 15:21
     * @Author 胖
     * 查询一级分类
     **/
    List<ShopGoodsClassify> queryAllOneLevelGoodsClassify(Integer shopId);

    /**
     * @Date 2020/5/22 16:00
     * @Author 胖
     * 查询某个一级分类下面的所有分类
     **/
    List<ShopGoodsClassify> queryOneLevelSubclassGoodsClassify(Integer supId, Integer shopId);

    /**
     * @Date 2020/5/22 15:21
     * @Author 胖
     * 删除某个分类
     **/
    Boolean deleteGoodsClassify(Integer classifyId);

    /**
     * @Date 2020/5/22 15:22
     * @Author 胖
     * 修改商品分类
     **/
    Boolean updateGoodsClassify(ShopGoodsClassify shopGoodsClassify);
}
