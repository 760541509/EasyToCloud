package com.yingtongquan.system.user.service;

import com.yingtongquan.startcommon.base.ResultVo;
import com.yingtongquan.system.user.entity.TblUserWxPo;
import com.yingtongquan.system.user.pojo.WXUserBindPhone;
import com.yingtongquan.system.user.pojo.WXUserInformation;

public interface TblUserWxService {

    /**
     * @Date 2020/5/14 17:41
     * @Author 胖虎
     * 微信授权登陆
     */
    ResultVo login(TblUserWxPo userWxPo);

    /**
     * @Date 2020/5/14 17:56
     * @Author 胖虎
     * 通过OPENID查询用户是否被我们数据库记录
     **/
    TblUserWxPo queryTheUserWithOPENID(String openId);

    /**
     * @Date 2020/5/15 9:39
     * @Author 胖虎
     * 添加用户信息
     **/
    void addWXUserInformation(TblUserWxPo userWxPo);

    /**
     * @Date 2020/5/15 10:51
     * @Author 胖虎
     * 通过绑定的手机号查询用户ID
     **/
    WXUserInformation theUserIDIsQueriedByTheMobilePhoneNumber(String phone);

    /**
     * @Date 2020/5/15 11:38
     * @Author 胖虎
     * 小程序绑定微信手机号
     **/
    void bindWXUserPhone(WXUserBindPhone userBindPhone,Integer userId);

    /**
     * @Date 2020/5/15 11:47
     * @Author 胖虎
     * 通过ID查询微信用户信息
     **/
    TblUserWxPo queryWXUserInformation(Integer id);

    /**
     * @Date 2020/5/15 11:54
     * @Author 胖虎
     * 添加微信用户手机号
     **/
    void addWeChatUserPhone(String phone,String openId,String sessionKey);

    /**
     * @Date 2020/5/15 12:07
     * @Author 胖虎
     * 修改用户SessionKey
     **/
    void modifyTheUserSessionKey(String openId,String sessionKey);

}
