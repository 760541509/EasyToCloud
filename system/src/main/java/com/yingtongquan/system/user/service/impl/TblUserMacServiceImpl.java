package com.yingtongquan.system.user.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.system.user.entity.TblUserMacPo;
import com.yingtongquan.system.user.mapper.TblUserMacMapper;
import com.yingtongquan.system.user.service.TblUserMacService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-06
 */
@Service
public class TblUserMacServiceImpl extends ServiceImpl<TblUserMacMapper, TblUserMacPo> implements TblUserMacService {

    @Resource
    private TblUserMacMapper userMacMapper;

    @Override
    public List<TblUserMacPo> queryAllUserMAC(TblUserMacPo userMacPo) {
        return userMacMapper.queryAllUserMAC(userMacPo);
    }
}
