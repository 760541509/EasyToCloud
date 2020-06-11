package com.yingtongquan.employees.member.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.member.entity.TblMemberPriceShopPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-05-21
*/
@Mapper
@Repository
public interface TblMemberPriceShopMapper extends BaseMapper<TblMemberPriceShopPo> {

    /**
     * @Date 2020/5/21 16:49
     * @Author 胖
     * 添加门店会员价格表
     **/
    void addMemberPriceShop(TblMemberPriceShopPo memberPriceShopPo);

    /**
     * @Date 2020/6/9 10:54
     * @Author 胖
     * 查询门店会员价格表
     **/
    TblMemberPriceShopPo queryMemberPriceShop(Integer id);

    /**
     * @Date 2020/6/9 11:00
     * @Author 胖
     * 修改门店会员价格表
     **/
    Boolean updateMemberPriceShop(TblMemberPriceShopPo memberPriceShopPo);

    /**
     * @Date 2020/6/9 11:10
     * @Author 胖
     * 查询门店所有已开启的会员
     **/
    List<TblMemberPriceShopPo> queryAllOpenMembershipPricesInTheStore(Integer shopId);

    /**
     * @Date 2020/6/9 11:10
     * @Author 胖
     * 查询门店所有的会员
     **/
    List<TblMemberPriceShopPo> queryAllMembershipPricesInTheStore(Integer shopId);

    /**
     * @Date 2020/6/9 15:20
     * @Author 胖
     * 关闭门店已开启的会员
     **/
    Boolean updateShopMember(Integer id);
}
