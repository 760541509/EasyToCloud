package com.yingtongquan.order.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import com.yingtongquan.order.order.entity.TblOrderGoodsPo;
import com.yingtongquan.order.order.entity.TblOrderPo;
import com.yingtongquan.order.order.mapper.TblOrderGoodsMapper;
import com.yingtongquan.order.order.mapper.TblOrderMapper;
import com.yingtongquan.order.order.pojo.*;
import com.yingtongquan.order.order.service.TblOrderGoodsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author Pang
 * @since 2020-05-12
 */
@Service
public class TblOrderGoodsServiceImpl extends ServiceImpl<TblOrderGoodsMapper, TblOrderGoodsPo> implements TblOrderGoodsService {

    @Resource
    private TblOrderMapper orderMapper;
    @Resource
    private TblOrderGoodsMapper orderGoodsMapper;


    @Override
    public void addOrderGoodsInformation(OrderGoodsInformation orderGoodsInformation, Integer curUserId, String orderNumber, Integer shopId) {

        //查询用户会员信息
        MemberInformation memberInformation = orderMapper.queryShopMemberInfromation(curUserId, shopId);
        //订单商品详细
        TblOrderPo orderInformation = orderMapper.queryOrderInformation(orderNumber);
        //查询商品的一部分信息
        GoodsInfromation goodsInfromation = queryGoodsInformation(orderGoodsInformation.getShopGoodsId());
        //查询用户对应商品的价格
        GoodsShopPrice shopPrice = orderMapper.queryGoodsMemberPrice(orderGoodsInformation.getGoodsSkuUnitId(), memberInformation.getMemberId(), orderGoodsInformation.getGoodsSkuId());
        //商品的轮播图
        List<String> imageList = Lists.newArrayList(goodsInfromation.getCarouselImage().split(";"));
        //订单商品表
        TblOrderGoodsPo orderGoodsPo = new TblOrderGoodsPo();
        orderGoodsPo.setAmount(orderGoodsInformation.getAmount());                                      //商品的数量
        orderGoodsPo.setDistributorCommissionRate(goodsInfromation.getDistributorCommissionRate());     //商品的分销商佣金百分比
        orderGoodsPo.setGoodsSkuId(orderGoodsInformation.getGoodsSkuId());                              //共用商品sku的id
        orderGoodsPo.setGoodsSkuUnitId(orderGoodsInformation.getGoodsSkuUnitId());                      //共用商品单位id
        for (int i = 0; i < imageList.size(); i++) {
            orderGoodsPo.setImage(imageList.get(0));                                                    //取第一张图片
        }
        orderGoodsPo.setOrderGoodsName(goodsInfromation.getName());                                     //商品的名字
        orderGoodsPo.setOrderId(orderInformation.getId());                                              //订单的ID
        orderGoodsPo.setOriginalPrice(shopPrice.getPrice());                                            //商品的原单价
        orderGoodsPo.setPrice(orderGoodsInformation.getPrice());                                        //购买的单价
        orderGoodsPo.setShareCouponsPrice(orderGoodsInformation.getShareCouponsPrice());                //分摊的优惠券价格
        orderGoodsPo.setShopGoodsId(orderGoodsInformation.getShopGoodsId());                            //商品的ID
        orderGoodsPo.setStaffCommissionRate(goodsInfromation.getStaffCommissionRate());                 //商品的员工佣金百分比
        orderGoodsPo.setStoreAmount(0);
        orderGoodsMapper.addOrderGoodsInformation(orderGoodsPo);
    }

    @Override
    public void addIndividualTravelerOrderGoodsInformation(OrderGoods orderGood, String orderNumber, Integer shopId, Integer memberPriceId, Integer memberId) {
        //订单商品详细
        TblOrderPo orderInformation = orderMapper.queryOrderInformation(orderNumber);
        //查询商品的一部分信息
        GoodsInfromation goodsInfromation = queryGoodsInformation(orderGood.getShopGoodsId());
        //商品的轮播图
        List<String> imageList = Lists.newArrayList(goodsInfromation.getCarouselImage().split(";"));
        //查询对应商品的价格
//        GoodsShopPrice shopPrice = null;
//        if (memberId == 0) {
        GoodsShopPrice shopPrice = orderMapper.queryGoodsIndividualTravelerPrice(orderGood.getGoodsSkuUnitId(), memberPriceId, orderGood.getGoodsSkuId());
//        } else {
//            shopPrice = orderMapper.queryGoodsMemberPrice(orderGood.getGoodsSkuUnitId(), memberId, orderGood.getGoodsSkuId());
//        }
        //订单实体类对象
        TblOrderGoodsPo orderGoodsPo = new TblOrderGoodsPo();
        //实际发货数量
        orderGoodsPo.setStoreAmount(0);
        //购买的数量
        orderGoodsPo.setAmount(orderGood.getAmount());
        //分销商佣金百分比
        orderGoodsPo.setDistributorCommissionRate(goodsInfromation.getDistributorCommissionRate());
        //共用商品sku的id
        orderGoodsPo.setGoodsSkuId(orderGood.getGoodsSkuId());
        //共用商品单位id
        orderGoodsPo.setGoodsSkuUnitId(orderGood.getGoodsSkuUnitId());
        //商品图   取第一张图片
        for (int i = 0; i < imageList.size(); i++) {
            orderGoodsPo.setImage(imageList.get(0));
        }
        //商品的原单价
        orderGoodsPo.setOriginalPrice(shopPrice.getPrice());
        //订单商品名称
        orderGoodsPo.setOrderGoodsName(goodsInfromation.getName());
        //订单的id
        orderGoodsPo.setOrderId(orderInformation.getId());
        //购买的单价
        orderGoodsPo.setPrice(orderGood.getPrice());
        //分摊的优惠券价格
        orderGoodsPo.setShareCouponsPrice(0);
        //门店商品id
        orderGoodsPo.setShopGoodsId(orderGood.getShopGoodsId());
        //员工佣金百分比
        orderGoodsPo.setStaffCommissionRate(goodsInfromation.getStaffCommissionRate());
        orderGoodsMapper.addOrderGoodsInformation(orderGoodsPo);
    }

    @Override
    public GoodsInfromation queryGoodsInformation(Integer goodsId) {
        return orderGoodsMapper.queryGoodsInformation(goodsId);
    }

    @Override
    public Boolean reOrderGoods(Integer orderId) {
        return orderGoodsMapper.reOrderGoods(orderId);
    }
}
