package com.yingtongquan.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.system.user.entity.TblUserPo;
import com.yingtongquan.system.user.pojo.LoginSuccess;
import com.yingtongquan.system.user.pojo.UserLogin;
import com.yingtongquan.system.user.pojo.UserRegis;

import java.io.UnsupportedEncodingException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-06
 */
public interface TblUserService extends IService<TblUserPo> {

    /**
     * @Date 2020/5/6 11:19
     * @Author 胖虎
     * 注册
     **/
    Boolean addUserInformation(UserRegis userRegis);

    /**
     * @Date 2020/5/6 11:20
     * @Author 胖虎
     * 登陆
     **/
    LoginSuccess login(UserLogin login) throws UnsupportedEncodingException;

    /**
     * @Date 2020/5/6 11:21
     * @Author 胖虎
     * 修改密码
     **/
    Boolean updateUserInformation(UserLogin login);

    /**
     * @Date 2020/5/6 14:03
     * @Author 胖虎
     * 检验该账号是否存在
     **/
    TblUserPo checkIfTheAccountExists(String account);


    /**
     * @Date 2020/5/15 10:46
     * @Author 胖虎
     * 注册账号
     **/
    void registeredAccount(TblUserPo userPo);

    /**
     * @Date 2020/6/5 14:17
     * @Author 胖
     * 切换店铺
     **/
    LoginSuccess switchTheStore(Integer shopId);

    /**
     * @Date 2020/6/9 15:33
     * @Author 胖
     * 根据手机号查询用户详细
     **/
    TblUserPo queryUserInformation(String account);
}