package com.yingtongquan.customer.order.service.impl;

import com.yingtongquan.customer.order.dao.UserOrderDao;
import com.yingtongquan.customer.order.pojo.Order;
import com.yingtongquan.customer.order.service.UserOrderService;
import com.yingtongquan.startcommon.util.HttpUtil;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class UserOrderServiceImpl implements UserOrderService {

    @Resource
    private HttpServletRequest request;

    @Resource
    private UserOrderDao userOrderDao;

    @Override
    public List<Order> queryUserAllOrder() {

        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        Integer userId;
        if("".equals(wx)){
            userId = HttpUtil.getCurUserId(token);
        }else if("WX".equals(wx)) {
            userId = userOrderDao.queryUserId(HttpUtil.getWXUserId(token));
        }












        return null;
    }
}
