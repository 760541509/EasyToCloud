package com.yingtongquan.employees.member.service.impl;

import cn.hutool.core.lang.Assert;
import com.yingtongquan.employees.member.entity.TblMemberPriceShopPo;
import com.yingtongquan.employees.member.mapper.TblMemberPriceShopMapper;
import com.yingtongquan.employees.member.service.TblMemberPriceShopService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@Service
public class TblMemberPriceShopServiceImpl extends ServiceImpl<TblMemberPriceShopMapper, TblMemberPriceShopPo> implements TblMemberPriceShopService {

    @Resource
    private TblMemberPriceShopMapper memberPriceShopMapper;
    @Resource
    private HttpServletRequest request;

    @Override
    public Boolean addShopMemberPrice(Integer shopId) {

        TblMemberPriceShopPo memberPriceShopPoOne = new TblMemberPriceShopPo();
        memberPriceShopPoOne.setPriceName("零售价");
        memberPriceShopPoOne.setShopId(shopId);
        memberPriceShopPoOne.setStatus(1);
        memberPriceShopPoOne.setType(0);
        memberPriceShopPoOne.setSupId(0);
        memberPriceShopMapper.addMemberPriceShop(memberPriceShopPoOne);

        TblMemberPriceShopPo memberPriceShopPoTwo = new TblMemberPriceShopPo();
        memberPriceShopPoTwo.setPriceName("零售价1");
        memberPriceShopPoTwo.setShopId(shopId);
        memberPriceShopPoTwo.setStatus(1);
        memberPriceShopPoTwo.setType(0);
        memberPriceShopPoTwo.setSupId(memberPriceShopPoOne.getId());
        memberPriceShopMapper.addMemberPriceShop(memberPriceShopPoTwo);
        for (int i = 2; i <= 5; i++) {
            TblMemberPriceShopPo memberPriceShopPoThree = new TblMemberPriceShopPo();
            memberPriceShopPoThree.setPriceName("零售价" + i);
            memberPriceShopPoThree.setShopId(shopId);
            memberPriceShopPoThree.setStatus(0);
            memberPriceShopPoThree.setType(0);
            memberPriceShopPoThree.setSupId(memberPriceShopPoOne.getId());
            memberPriceShopMapper.addMemberPriceShop(memberPriceShopPoThree);
        }

        TblMemberPriceShopPo memberPriceShopPoFour = new TblMemberPriceShopPo();
        memberPriceShopPoFour.setPriceName("批发价");
        memberPriceShopPoFour.setShopId(shopId);
        memberPriceShopPoFour.setStatus(1);
        memberPriceShopPoFour.setType(0);
        memberPriceShopPoFour.setSupId(0);
        memberPriceShopMapper.addMemberPriceShop(memberPriceShopPoFour);

        for (int i = 1; i <= 2; i++) {
            TblMemberPriceShopPo memberPriceShopPoFive = new TblMemberPriceShopPo();
            memberPriceShopPoFive.setPriceName("批发价");
            memberPriceShopPoFive.setShopId(shopId);
            memberPriceShopPoFive.setStatus(0);
            memberPriceShopPoFive.setType(0);
            memberPriceShopPoFive.setSupId(memberPriceShopPoFour.getId());
            memberPriceShopMapper.addMemberPriceShop(memberPriceShopPoFive);
        }

        return true;
    }

    @Override
    public Boolean updateShopMemberPrice(TblMemberPriceShopPo memberPriceShopPo) {
        TblMemberPriceShopPo priceShopPo = memberPriceShopMapper.queryMemberPriceShop(memberPriceShopPo.getId());
        Assert.isTrue("零售价".equals(priceShopPo.getPriceName()) || "批发价".equals(priceShopPo.getPriceName()), "基本价格单位名称不能修改");
        return memberPriceShopMapper.updateMemberPriceShop(memberPriceShopPo);
    }

    @Override
    public List<TblMemberPriceShopPo> queryShopAllMemberprice() {
        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);
        return memberPriceShopMapper.queryAllOpenMembershipPricesInTheStore(shopId);
    }

    @Override
    public List<TblMemberPriceShopPo> queryShopAllMember() {
        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);
        return memberPriceShopMapper.queryAllMembershipPricesInTheStore(shopId);
    }

    @Override
    public Boolean updateShopAllMemberprice(Integer id) {
        return memberPriceShopMapper.updateShopMember(id);
    }
}
