package com.yingtongquan.employees.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.member.entity.TblMemberShopPo;
import com.yingtongquan.employees.member.pojo.*;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
public interface TblMemberShopService extends IService<TblMemberShopPo> {

    /**
     * @Date 2020/6/5 12:19
     * @Author 胖
     * 查询会员
     **/
    List<MemberInformation> queryAllShopMember(UseTheQuery useTheQuery);

    /**
     * @Date 2020/6/5 16:53
     * @Author 胖
     * 添加会员
     **/
    Integer addShopMember(AddShopMember addShopMember);

    /**
     * @Date 2020/6/5 17:35
     * @Author 胖
     * 修改会员
     **/
    Boolean updateShopMember(UpdateMemberInformation memberInformation);

    /**
     * @Date 2020/6/11 15:19
     * @Author 胖
     * 修改会员地址
     **/
    Boolean updateMemberAddress(MemberAddress memberAddress);

    /**
     * @Date 2020/6/5 17:36
     * @Author 胖
     * 删除会员
     **/
    Boolean deleteShopMember(String account);

    /**
     * @Date 2020/6/10 17:33
     * @Author 胖
     * 按条件查询会员
     **/
    List<MemberInformation> queryByConditionMember(UseTheQuery useTheQuery);

    /**
     * @Date 2020/6/11 14:42
     * @Author 胖
     * 查询会员详细
     **/
    ShopMemberInfo queryMemberInformation(QueryMemberInformation memberInformation);

}
