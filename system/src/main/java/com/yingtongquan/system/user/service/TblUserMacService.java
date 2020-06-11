package com.yingtongquan.system.user.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.system.user.entity.TblUserMacPo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author Pang
 * @since 2020-05-06
 */
public interface TblUserMacService extends IService<TblUserMacPo> {

    /**
     * @Date 2020/5/6 12:06
     * @Author 胖虎
     * 查询该用户的MAC
     **/
    List<TblUserMacPo> queryAllUserMAC(TblUserMacPo userMacPo);
}
