package com.yingtongquan.employees.shop.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.shop.entity.TblShopPo;
import com.yingtongquan.employees.shop.pojo.ShopInformation;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblShopService extends IService<TblShopPo> {

    /**
     * @Date 2020/5/21 11:38
     * @Author 胖
     * 创建店铺
     **/
    ShopInformation addShopInformation(ShopInformation shopInformation);

    /**
     * @Date 2020/5/21 17:49
     * @Author 胖
     * 修改店铺信息
     **/
    Boolean updateShopInformation(ShopInformation shopInformation);

    /**
     * @Date 2020/5/21 17:55
     * @Author 胖
     * 查询老板名下所有的店铺
     **/
    List<ShopInformation> queryUserAllShopInformation();

    /**
     * @Date 2020/5/21 18:02
     * @Author 胖
     * 查询某个店铺详细
     **/
    ShopInformation queryShopInformation(Integer shopId);

    /**
     * @Date 2020/5/21 18:02
     * @Author 胖
     * 查询所有的店铺
     **/
    List<ShopInformation> queryAllShopInformation(Integer id, Integer pageNumber);

    /**
     * @Date 2020/5/21 18:03
     * @Author 胖
     * 删除店铺
     **/
    Boolean deleteShopInformation(Integer shopId);
}
