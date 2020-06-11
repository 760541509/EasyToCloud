package com.yingtongquan.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.system.user.entity.TblUserMacPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author Pang
 * @since 2020-05-06
 */
@Mapper
@Repository
public interface TblUserMacMapper extends BaseMapper<TblUserMacPo> {

    List<TblUserMacPo> queryAllUserMAC(TblUserMacPo userMacPo);
}
