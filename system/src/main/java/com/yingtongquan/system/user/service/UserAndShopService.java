package com.yingtongquan.system.user.service;

import com.yingtongquan.startcommon.pojo.LatAndLon;
import com.yingtongquan.system.user.pojo.AddressInformation;
import com.yingtongquan.system.user.pojo.LuckyDraw;

public interface UserAndShopService {

    /**
     * @Date 2020/6/3 10:38
     * @Author 胖
     * 抽奖转盘
     **/
    LuckyDraw lotteryTurntable(Integer shopId, Integer dialNumber);

    /**
     * @Date 2020/6/3 16:04
     * @Author 胖
     * 根据经纬度获取地址ID
     **/
    AddressInformation queryAreaId(LatAndLon latAndLon);


}
