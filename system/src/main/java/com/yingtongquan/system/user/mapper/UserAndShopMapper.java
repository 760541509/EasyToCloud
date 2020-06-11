package com.yingtongquan.system.user.mapper;

import com.yingtongquan.system.user.pojo.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserAndShopMapper {

    //查询登陆成功时返回的信息
    LoginSuccess queryUserInformation(String account);
    Integer queryUserShopId(Integer userId);
    String queryShopStoreIcon(Integer shopId);

    //查询所有的抽奖信息
    List<LuckyDraw> queryAllLuckyDraw(Integer shopId);

    //查询店铺的配置
    SystemConfig queryShopConfig(Integer shopId);

    //转盘的详细
    List<RotaryTable> queryRotaryTableAreaNumber(Integer dialNumber);

    //查询优惠卷信息
    Coupons queryCouponInformation(Integer couponId);

    //查询抽奖区的商品信息
    Product queryLuckyDrawGoodsInfromation(Integer productId);

    //微信ID查询用户ID
    Integer queryUserId(Integer WXId);

    //添加用户的抽奖表
    Boolean addUserAndCoupons(UserAndCoupons userAndCoupons);

    //根据区查询编号
    AddressInformation queryAreaId(String areaName);

    //查询权限
    LoginSuccess queryUserStaff(Integer shopId,Integer userId);

}

