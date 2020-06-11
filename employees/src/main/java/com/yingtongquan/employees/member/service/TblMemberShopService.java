package com.yingtongquan.employees.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.employees.member.entity.TblMemberShopPo;
import com.yingtongquan.employees.member.pojo.AddShopMember;
import com.yingtongquan.employees.member.pojo.MemberInformation;
import com.yingtongquan.employees.member.pojo.UseTheQuery;

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
    List<TblMemberShopPo> queryAllShopMember();

    /**
     * @Date 2020/6/5 16:53
     * @Author 胖
     * 添加会员
     **/
    Boolean addShopMember(AddShopMember addShopMember);

    /**
     * @Date 2020/6/5 17:35
     * @Author 胖
     * 修改会员
     **/
    Boolean updateShopMember(MemberInformation memberInformation);

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
    List<TblMemberShopPo> queryByConditionMember(UseTheQuery useTheQuery);
}
