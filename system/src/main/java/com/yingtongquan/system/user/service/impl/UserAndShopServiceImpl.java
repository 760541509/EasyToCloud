package com.yingtongquan.system.user.service.impl;


import com.google.common.collect.Lists;
import com.yingtongquan.startcommon.pojo.LatAndLon;
import com.yingtongquan.startcommon.util.AddressUtil;
import com.yingtongquan.startcommon.util.HttpUtil;
import com.yingtongquan.system.user.mapper.UserAndShopMapper;
import com.yingtongquan.system.user.pojo.*;
import com.yingtongquan.system.user.service.UserAndShopService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Random;

@Service
public class UserAndShopServiceImpl implements UserAndShopService {

    private final static List<LuckyDraw> LUCKY_DRAWS = Lists.newArrayList();

    @Resource
    private UserAndShopMapper userAndShopMapper;
    @Resource
    private HttpServletRequest request;

    @Override
    public LuckyDraw lotteryTurntable(Integer shopId, Integer dialNumber) {
        //抽中的信息
        LuckyDraw luckyDraw = luckyDraw(shopId, dialNumber);
        Boolean flg = addUserAndCoupons(luckyDraw.getCouponId(), luckyDraw.getProductId());
        if (flg) {
            return luckyDraw;
        }
        return null;
    }

    @Override
    public AddressInformation queryAreaId(LatAndLon latAndLon) {
        LatAndLon andLon = AddressUtil.getAnAddressBasedOnLatitudeAndLongitude(latAndLon);
        AddressInformation addressInformation = userAndShopMapper.queryAreaId(andLon.getDistrict());
        return addressInformation;
    }

    private Boolean addUserAndCoupons(Integer couponsId, Integer productId) {
        Integer curUserId = 0;
        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        if ("".equals(wx)) {
            curUserId = HttpUtil.getCurUserId(token);
        } else if ("WX".equals(wx)) {
            curUserId = userAndShopMapper.queryUserId(HttpUtil.getWXUserId(token));
        }
        UserAndCoupons userAndCoupons = new UserAndCoupons();
        if (couponsId != 0) {
            userAndCoupons.setCouponsId(couponsId);
        } else if (productId != 0) {
            userAndCoupons.setProductId(productId);
        }
        userAndCoupons.setGetTheTime(System.currentTimeMillis() );
        userAndCoupons.setIsLate("未过期");
        userAndCoupons.setUserId(curUserId);
        return userAndShopMapper.addUserAndCoupons(userAndCoupons);
    }

    private LuckyDraw luckyDraw(Integer shopId, Integer dialNumber) {
        List<LuckyDraw> luckyDraws = addLuckyDraws(shopId, dialNumber);
        Random random = new Random();
        String randomNumber = String.valueOf(random.nextDouble()).substring(0, 4);
        for (LuckyDraw luckyDraw : luckyDraws) {
            if (Double.valueOf(randomNumber) <= luckyDraw.getChance()) {
                return luckyDraw;
            }
        }
        return null;
    }

    private List<LuckyDraw> addLuckyDraws(Integer shopId, Integer dialNumber) {
        List<LuckyDraw> luckyDraws = userAndShopMapper.queryAllLuckyDraw(shopId);
        SystemConfig systemConfig = userAndShopMapper.queryShopConfig(shopId);
        List<RotaryTable> rotaryTables = userAndShopMapper.queryRotaryTableAreaNumber(systemConfig.getRotaryTable());
        int areaNumber = 0;
        for (RotaryTable rotaryTable : rotaryTables) {
            if (rotaryTable.getAreaNumber().equals(dialNumber)) {
                areaNumber = rotaryTable.getAreaNumber();
            }
        }

        for (int i = 0; i <= areaNumber; i++) {
            LUCKY_DRAWS.add(new LuckyDraw(luckyDraws.get(i).getId(), luckyDraws.get(i).getCouponId(), luckyDraws.get(i).getChance(), luckyDraws.get(i).getProductId()));
        }
        return LUCKY_DRAWS;
    }
}
