package com.yingtongquan.employees.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.member.entity.TblMemberDeliveryAddressShopPo;
import com.yingtongquan.employees.member.entity.TblMemberShopPo;
import com.yingtongquan.employees.member.pojo.*;
import com.yingtongquan.employees.staff.pojo.UserInformation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Mapper
@Repository
public interface TblMemberShopMapper extends BaseMapper<TblMemberShopPo> {

    //查询所有会员
    List<MemberInformation> queryAllShopMember(UseTheQuery useTheQuery);

    //按条件查询会员
//    List<MemberInformation> queryByCondition(UseTheQuery useTheQuery);

    //查询最近一次下单时间
    List<Long> checkLastOrderTime(Integer userId);

    //查询是否已绑定微信
    Integer bindWeChat(Integer userId);

    //查询会员价名称
    String queryMember(Integer memberId);

    //查询改账号是否在本平台注册
    UserInformation queryUserInfromation(String account);

    //注册账号
    Boolean addUserInformation(UserInformation userInformation);

    //添加会员
    Boolean addShopMember(TblMemberShopPo memberShopPo);

    //查询地区ID
    Integer queryAreaId(MemberAddress memberAddress);

    //修改会员
    Boolean updateShopMember(UpdateMemberInformation memberInformation);

    //删除会员
    Boolean deleteShopMember(String account);

    //添加会员地址
    Boolean addMemberAddress(TblMemberDeliveryAddressShopPo memberDeliveryAddress);

    //查询会员信息
    ShopMemberInfo  queryMemberInformation(Integer id);

    //查询收货地址
    List<MemberAddress> queryMemberShippingAddress(Integer memberId);

    //修改收货地址
    Boolean updateMemberShippingAddress(TblMemberDeliveryAddressShopPo memberDelivery);
}
