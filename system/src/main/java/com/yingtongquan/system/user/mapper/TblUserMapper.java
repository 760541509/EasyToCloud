package com.yingtongquan.system.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.system.user.entity.TblUserAndShopPo;
import com.yingtongquan.system.user.entity.TblUserPo;
import com.yingtongquan.system.user.pojo.ShopInfromation;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


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
public interface TblUserMapper extends BaseMapper<TblUserPo> {

    TblUserPo queryUserInformation(String account);

    Boolean updateUserMAC(String account,String mac);

    Boolean updateUserPassword(String account,String password);

    TblUserPo checkIfTheAccountExists(String account);

    Boolean addUserInformation(TblUserPo userPo);

    Integer queryUserId(Integer WXId);

    Boolean addUserAndShopRelationshipBetween(TblUserAndShopPo userAndShopPo);

    Boolean updateUserAndShopRelationshipBetween(Integer userId);

    TblUserPo queryUser(Integer userId);

    ShopInfromation queryShopInformation(Integer shopId);
}


