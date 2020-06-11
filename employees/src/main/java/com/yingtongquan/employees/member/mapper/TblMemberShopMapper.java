package com.yingtongquan.employees.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.member.entity.TblMemberShopPo;
import com.yingtongquan.employees.member.pojo.MemberInformation;
import com.yingtongquan.employees.member.pojo.UseTheQuery;
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
    List<TblMemberShopPo> queryAllShopMember(Integer shopId);

    //按条件查询会员
    List<TblMemberShopPo> queryByCondition(UseTheQuery useTheQuery);

    //查询会员价名称
    String queryMember(Integer memberId);

    //查询改账号是否在本平台注册
    UserInformation queryUserInfromation(String account);

    //注册账号
    Boolean addUserInformation(UserInformation userInformation);

    //添加会员
    Boolean addShopMember(TblMemberShopPo memberShopPo);

    //修改会员
    Boolean updateShopMember(MemberInformation memberInformation);

    //删除会员
    Boolean deleteShopMember(String account);
}
