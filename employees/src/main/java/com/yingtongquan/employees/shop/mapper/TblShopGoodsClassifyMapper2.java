package com.yingtongquan.employees.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.shop.entity.TblShopGoodsClassifyPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-21
*/
@Mapper
@Repository
public interface TblShopGoodsClassifyMapper2 extends BaseMapper<TblShopGoodsClassifyPo> {

//    /**
//     * @Date 2020/5/22 14:41
//     * @Author 胖
//     * 查询店铺下所有的商品分类
//     **/
//    List<ShopGoodsClassify> queryShopAllGoodsInformation(Integer shopId);
//
//    /**
//     * @Date 2020/5/22 15:40
//     * @Author 胖
//     * 发布商品分类
//     **/
//    Boolean addShopGoodsClassify(TblShopGoodsClassifyPo shopGoodsClassifyPo);
//
//    /**
//     * @Date 2020/5/22 15:52
//     * @Author 胖
//     * 查询所有的一级分类
//     **/
//    List<ShopGoodsClassify> queryShopGoodsOneLevelClassify(Integer supId, Integer shopId);
//
//    /**
//     * @Date 2020/5/22 16:11
//     * @Author 胖
//     * 删除某个分类
//     **/
//    Boolean deleteGoodsClassify(Integer classifyId);
//
//    /**
//     * @Date 2020/5/22 16:14
//     * @Author 胖
//     * 修改商品分类
//     **/
//    Boolean updateGoodsClassify(ShopGoodsClassify shopGoodsClassify);
}
