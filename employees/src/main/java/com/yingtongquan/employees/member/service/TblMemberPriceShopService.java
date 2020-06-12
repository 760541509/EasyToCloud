package com.yingtongquan.employees.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.member.entity.TblMemberPriceShopPo;
import com.yingtongquan.employees.member.pojo.ShopPrice;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblMemberPriceShopService extends IService<TblMemberPriceShopPo> {

    /**
     * @Date 2020/5/21 16:44
     * @Author 胖
     * 自动添加门店会员价格表
     **/
    Boolean addShopMemberPrice(Integer shopId);

    /**
     * @Date 2020/6/9 10:48
     * @Author 胖
     * 修改门店会员价格表
     **/
    Boolean updateShopMemberPrice(TblMemberPriceShopPo memberPriceShopPo);

    /**
     * @Date 2020/6/9 10:50
     * @Author 胖
     * 查询门店所有以开启的会员价格表
     **/
    List<TblMemberPriceShopPo> queryShopAllMemberprice();

    /**
     * @Date 2020/6/9 15:24
     * @Author 胖
     * 查询门店所有的会员价格
     **/
    ShopPrice queryShopAllMember();

    /**
     * @Date 2020/6/9 10:50
     * @Author 胖
     * 关闭门店会员价格表
     **/
    Boolean updateShopAllMemberprice(Integer id,Integer status);
}
