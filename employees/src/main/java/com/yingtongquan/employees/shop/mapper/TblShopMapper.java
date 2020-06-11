package com.yingtongquan.employees.shop.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.shop.entity.TblShopPo;
import com.yingtongquan.employees.shop.pojo.ShopInformation;
import com.yingtongquan.startcommon.address.pojo.Address;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

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
public interface TblShopMapper extends BaseMapper<TblShopPo> {

    /**
     * @Date 2020/5/21 14:36
     * @Author 胖
     * 查询详细地址
     **/
    Address queryCityAndProvincial(Integer areaId);

    /**
     * @Date 2020/5/21 15:01
     * @Author 胖
     * 通过微信ID查询用户ID
     **/
     Integer queryUserId(Integer WXUserId);

     /**
      * @Date 2020/5/21 15:37
      * @Author 胖
      * 添加店铺信息
      **/
     Boolean addShopInformation(TblShopPo shopPo);

     /**
      * @Date 2020/5/22 9:57
      * @Author 胖
      * 修改店铺信息
      **/
     Boolean updateShopInformation(TblShopPo shopPo);

     /**
      * @Date 2020/5/22 10:02
      * @Author 胖
      * 查询某老板名下所有店铺
      **/
     List<ShopInformation> queryUserAllShopInformation(Integer userId);

    /**
     * @Date 2020/5/22 12:16
     * @Author 胖
     * 按照店铺ID查询店铺详细的信息
     **/
    ShopInformation queryShopInformation(Integer shopId);

    /**
     * @Date 2020/5/22 14:55
     * @Author 胖
     * 查询所有的店铺
     **/
    List<ShopInformation> queryAllShopInformation(Integer id, Integer pageNumber);

    /**
     * @Date 2020/5/22 14:58
     * @Author 胖
     * 删除店铺
     **/
    Boolean deleteShop(Integer shopId);

    /**
     * @Date 2020/5/22 15:11
     * @Author 胖
     * 查询店铺信息  删除时使用
     **/
    TblShopPo queryStoreInformation(Integer shopId);

}
