package com.yingtongquan.employees.shop.controller;


import com.yingtongquan.employees.shop.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.shop.pojo.ShopGoodsClassify;
import com.yingtongquan.employees.shop.pojo.ShopInformation;
import com.yingtongquan.employees.shop.pojo.ShopShippingAddress;
import com.yingtongquan.employees.shop.service.TblShopDeliveryAddressService;
import com.yingtongquan.employees.shop.service.TblShopGoodsClassifyService;
import com.yingtongquan.employees.shop.service.TblShopService;
import com.yingtongquan.startcommon.base.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author ML
 * @since 2020-05-21
 */
@RestController
@RequestMapping("/shop/tblShopPo")
@Api(tags = "店铺操作")
public class TblShopController {

    @Resource
    private RedisTemplate redisTemplate;

    @Resource
    private TblShopService shopService;
    @Resource
    private TblShopGoodsClassifyService shopGoodsClassifyService;
    @Resource
    private TblShopDeliveryAddressService shopDeliveryAddressService;

    @ApiOperation(value = "发布店铺")
    @PostMapping("/addShopInformation")
    public ResultVo addShopInformation(@RequestBody ShopInformation shopInformation) {
        return ResultVo.successResult(shopService.addShopInformation(shopInformation));
    }

    @ApiOperation(value = "发布商品分类")
    @PostMapping("/publishProductClassification")
    public ResultVo publishProductClassification(@RequestBody TblShopGoodsClassifyPo shopGoodsClassifyPo) {
        return ResultVo.successResult(shopGoodsClassifyService.addShopGoodsClassify(shopGoodsClassifyPo));
    }

    @ApiOperation(value = "添加店铺收货地址")
    @PostMapping("/addTheStoreShippingAddress")
    public ResultVo addTheStoreShippingAddress(@RequestBody ShopShippingAddress shopShippingAddress) {
        return ResultVo.successResult(shopDeliveryAddressService.addShopShippingAddress(shopShippingAddress));
    }

    @ApiOperation(value = "查询所有的商品分类")
    @PostMapping("/queryAllProductCategories")
    public ResultVo queryAllProductCategories(Integer shopId, Integer id, Integer pageNumber) {
        Boolean hasKey = redisTemplate.hasKey(shopId + "GoodsClassify");
        if (hasKey) {
            return ResultVo.successResult(redisTemplate.opsForList().range(shopId + "GoodsClassify", 0, -1));
        } else {
            List<ShopGoodsClassify> shopGoodsClassifies = shopGoodsClassifyService.queryShopAllGoodsInformation(shopId);
            if (shopGoodsClassifies.size() > 0) {
                redisTemplate.opsForList().rightPush(shopId + "GoodsClassify", shopGoodsClassifies);
                redisTemplate.expire(shopId + "GoodsClassify", 60 * 5, TimeUnit.SECONDS);
            }
            return ResultVo.successResult(shopGoodsClassifies);
        }
    }

    @ApiOperation(value = "查询所有的一级分类")
    @PostMapping("/queryForAllFirstLevelCategories")
    public ResultVo queryForAllFirstLevelCategories(Integer shopId) {

        Boolean hasKey = redisTemplate.hasKey(shopId + "OneLevel");
        if (hasKey) {
            return ResultVo.successResult(redisTemplate.opsForList().range(shopId + "OneLevel", 0, -1));
        } else {
            List<ShopGoodsClassify> shopGoodsClassifies = shopGoodsClassifyService.queryAllOneLevelGoodsClassify(shopId);
            if (shopGoodsClassifies.size() > 0) {
                redisTemplate.opsForList().rightPush(shopId + "OneLevel", shopGoodsClassifies);
                redisTemplate.expire(shopId + "OneLevel", 5 * 60, TimeUnit.SECONDS);
            }
            return ResultVo.successResult(shopGoodsClassifies);
        }
    }

    @ApiOperation(value = "查询某个一级分类下的子分类")
    @PostMapping("/queryForSubcategoriesUnderAPrimaryCategory")
    public ResultVo queryForSubcategoriesUnderAPrimaryCategory(Integer supId, Integer shopId) {
        return ResultVo.successResult(shopGoodsClassifyService.queryOneLevelSubclassGoodsClassify(supId, shopId));
    }

    @ApiOperation(value = "修改某个分类属性")
    @PostMapping("/modifyAClassificationProperty")
    public ResultVo modifyAClassificationProperty(@RequestBody ShopGoodsClassify shopGoodsClassify) {
        return ResultVo.successResult(shopGoodsClassifyService.updateGoodsClassify(shopGoodsClassify));
    }

    @ApiOperation(value = "删除某个分类")
    @PostMapping("/deleteACategory")
    public ResultVo deleteACategory(Integer classifyId) {
        return ResultVo.successResult(shopGoodsClassifyService.deleteGoodsClassify(classifyId));
    }

    @ApiOperation(value = "查询所有的店铺")
    @PostMapping("/checkAllStores")
    public ResultVo checkAllStores(Integer id, Integer pageNumber) {

        Boolean hasKey = redisTemplate.hasKey("AllShopInformation");
        if (hasKey) {
            return ResultVo.successResult(redisTemplate.opsForList().range("AllShopInformation", 0, -1));
        } else {
            List<ShopInformation> shopInformations = shopService.queryAllShopInformation(id, pageNumber);
            if (shopInformations.size() > 0) {
                redisTemplate.opsForList().rightPush("AllShopInformation", shopInformations);
                redisTemplate.expire("AllShopInformation", 10 * 60, TimeUnit.SECONDS);
            }
            return ResultVo.successResult(shopInformations);
        }
    }

    @ApiOperation(value = "查询某一个店铺的详情")
    @PostMapping("/inquireTheDetailsOfAParticularShop")
    public ResultVo inquireTheDetailsOfAParticularShop(Integer shopId) {
        return ResultVo.successResult(shopService.queryShopInformation(shopId));
    }

    @ApiOperation(value = "查询某一个老板的所有店铺")
    @PostMapping("/checkAllTheStoresOfACertainBoss")
    public ResultVo checkAllTheStoresOfACertainBoss() {
        return ResultVo.successResult(shopService.queryUserAllShopInformation());
    }

    @ApiOperation(value = "修改店铺信息")
    @PostMapping("/modifyStoreInformation")
    public ResultVo modifyStoreInformation(@RequestBody ShopInformation shopInformation) {
        return ResultVo.successResult(shopService.updateShopInformation(shopInformation));
    }

    @ApiOperation(value = "删除店铺信息")
    @PostMapping("/deleteStoreInformation")
    public ResultVo deleteStoreInformation(Integer shopId) {
        return ResultVo.successResult(shopService.deleteShopInformation(shopId));
    }

    @ApiOperation(value = "修改默认地址")
    @PostMapping("/modifyTheDefaultAddress")
    public ResultVo modifyTheDefaultAddress(Integer id, Integer shopId) {
        return ResultVo.successResult(shopDeliveryAddressService.setTheAddressToTheDefaultShippingAddress(id, shopId));
    }

    @ApiOperation(value = "查询店铺名下所有的收货地址")
    @PostMapping("/checkAllShippingAddressesUnderTheStoreName")
    public ResultVo checkAllShippingAddressesUnderTheStoreName(Integer shopId) {

        Boolean hasKey = redisTemplate.hasKey(shopId + "shippingAddress");

        if (hasKey) {
            return ResultVo.successResult(redisTemplate.opsForList().range(shopId + "shippingAddress", 0, -1));
        } else {
            List<ShopShippingAddress> shopShippingAddresses = shopDeliveryAddressService.queryShopAllShippingAddress(shopId);
            if (shopShippingAddresses.size() > 0) {
                redisTemplate.opsForList().rightPush(shopId + "shippingAddress", shopShippingAddresses);
                redisTemplate.expire(shopId + "shippingAddress", 5 * 60, TimeUnit.SECONDS);
            }
            return ResultVo.successResult(shopShippingAddresses);
        }
    }

    @ApiOperation(value = "查询某一个地址详情")
    @PostMapping("/inquireForDetailsOfAParticularAddress")
    public ResultVo inquireForDetailsOfAParticularAddress(Integer id) {
        return ResultVo.successResult(shopDeliveryAddressService.queryAddress(id));
    }

    @ApiOperation(value = "修改收货地址")
    @PostMapping("/modifyTheShippingAddress")
    public ResultVo modifyTheShippingAddress(@RequestBody ShopShippingAddress shopShippingAddress) {
        return ResultVo.successResult(shopDeliveryAddressService.updateShopShippingAddress(shopShippingAddress));
    }

    @ApiOperation(value = "删除收货地址")
    @PostMapping("/deleteShippingAddress")
    public ResultVo deleteShippingAddress(Integer id, Integer shopId) {
        return ResultVo.successResult(shopDeliveryAddressService.deleteShopShippingAddress(id, shopId));
    }
}
