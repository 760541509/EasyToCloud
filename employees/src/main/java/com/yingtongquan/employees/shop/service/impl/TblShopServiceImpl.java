package com.yingtongquan.employees.shop.service.impl;

import cn.hutool.core.lang.Assert;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.member.service.TblMemberPriceShopService;
import com.yingtongquan.employees.shop.entity.TblShopPo;
import com.yingtongquan.employees.shop.mapper.TblShopMapper;
import com.yingtongquan.employees.shop.pojo.ShopInformation;
import com.yingtongquan.employees.shop.service.TblShopDeliveryAddressService;
import com.yingtongquan.employees.shop.service.TblShopGoodsClassifyService;
import com.yingtongquan.employees.shop.service.TblShopService;
import com.yingtongquan.employees.staff.service.TblStaffRoleService;
import com.yingtongquan.employees.staff.service.TblStaffService;
import com.yingtongquan.employees.warehouse.pojo.WarehouseInformation;
import com.yingtongquan.employees.warehouse.service.TblWarehouseService;
import com.yingtongquan.startcommon.address.pojo.Address;
import com.yingtongquan.startcommon.address.pojo.Coordinate;
import com.yingtongquan.startcommon.util.AddressUtil;
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
public class TblShopServiceImpl extends ServiceImpl<TblShopMapper, TblShopPo> implements TblShopService {

    @Resource
    private HttpServletRequest request;

    @Resource
    private TblShopMapper shopMapper;
    @Resource
    private TblWarehouseService warehouseService;
    @Resource
    private TblMemberPriceShopService memberPriceShopService;
    @Resource
    private TblStaffService staffService;
    @Resource
    private TblStaffRoleService staffRoleService;
    @Resource
    private TblShopGoodsClassifyService shopGoodsClassifyService;
    @Resource
    private TblShopDeliveryAddressService shopDeliveryAddressService;


    @Override
    public ShopInformation addShopInformation(ShopInformation shopInformation) {
        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        Address address = shopMapper.queryCityAndProvincial(shopInformation.getAreaId());
        String detailedAddress = address.getProvince() + address.getCity() + address.getArea() + shopInformation.getAddress();
        shopInformation.setProvince(address.getProvince());
        shopInformation.setCity(address.getCity());
        shopInformation.setArea(address.getArea());
        Coordinate coordinate = AddressUtil.coordinate(detailedAddress);
        TblShopPo shopPo = new TblShopPo();
        shopPo.setAddress(shopInformation.getAddress());
        shopPo.setAddTime(System.currentTimeMillis());
        shopPo.setAreaId(shopInformation.getAreaId());
        shopPo.setImages(shopInformation.getImages());
        shopPo.setLatitude(coordinate.getLatitude());
        shopPo.setLongitude(coordinate.getLongitude());
        shopPo.setPhone(shopInformation.getPhone());
        shopPo.setStoreIcon(shopInformation.getStoreIcon());
        shopPo.setStoreName(shopInformation.getStoreName());
        shopPo.setTelephone(shopInformation.getTelephone());
        shopPo.setStatus(0);
        Integer userId;
        if ("".equals(wx)) {
            userId = HttpUtil.getCurUserId(token);
            shopPo.setUserId(HttpUtil.getCurUserId(token));
        } else {
            userId = shopMapper.queryUserId(HttpUtil.getWXUserId(token));
            shopPo.setUserId(userId);
        }
        WarehouseInformation warehouseInformation = new WarehouseInformation();
        warehouseInformation.setWarehouseName("默认仓库");
        warehouseInformation.setDontAllow(0);
        shopMapper.addShopInformation(shopPo);
        shopInformation.setId(shopPo.getId());
        staffService.addShopStaff(shopPo.getId(), userId);
        warehouseService.addShopExclusiveWarehouse(shopPo, warehouseInformation);
        memberPriceShopService.addShopMemberPrice(shopPo.getId());
        staffRoleService.addDefaultRoles(shopPo.getId());
        return shopInformation;
    }

    @Override
    public Boolean updateShopInformation(ShopInformation shopInformation) {
        Address address = shopMapper.queryCityAndProvincial(shopInformation.getAreaId());
        String detailedAddress = address.getProvince() + address.getCity() + address.getArea() + shopInformation.getAddress();
        Coordinate coordinate = AddressUtil.coordinate(detailedAddress);
        TblShopPo shopPo = new TblShopPo();
        shopPo.setId(shopInformation.getId());
        shopPo.setAddress(shopInformation.getAddress());
        shopPo.setAreaId(shopInformation.getAreaId());
        shopPo.setImages(shopInformation.getImages());
        shopPo.setLatitude(coordinate.getLatitude());
        shopPo.setLongitude(coordinate.getLongitude());
        shopPo.setPhone(shopInformation.getPhone());
        shopPo.setStoreIcon(shopInformation.getStoreIcon());
        shopPo.setStoreName(shopInformation.getStoreName());
        shopPo.setTelephone(shopInformation.getTelephone());
        return shopMapper.updateShopInformation(shopPo);
    }

    @Override
    public List<ShopInformation> queryUserAllShopInformation() {
        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        List<ShopInformation> shopInformations;
        if ("".equals(wx)) {
            shopInformations = shopMapper.queryUserAllShopInformation(HttpUtil.getCurUserId(token));
        } else {
            shopInformations = shopMapper.queryUserAllShopInformation(shopMapper.queryUserId(HttpUtil.getWXUserId(token)));
        }
        for (ShopInformation shopInformation : shopInformations) {
            Address address = shopMapper.queryCityAndProvincial(shopInformation.getAreaId());
            shopInformation.setProvince(address.getProvince());
            shopInformation.setCity(address.getCity());
            shopInformation.setArea(address.getArea());
        }
        return shopInformations;
    }

    @Override
    public ShopInformation queryShopInformation(Integer shopId) {
        ShopInformation shopInformation = shopMapper.queryShopInformation(shopId);
        shopInformation.setShopGoodsClassifies(shopGoodsClassifyService.queryShopAllGoodsInformation(shopInformation.getId()));
        shopInformation.setShopShippingAddresses(shopDeliveryAddressService.queryShopAllShippingAddress(shopInformation.getId()));
        return shopInformation;
    }

    @Override
    public List<ShopInformation> queryAllShopInformation(Integer id, Integer pageNumber) {
        return shopMapper.queryAllShopInformation(id, pageNumber);
    }

    @Override
    public Boolean deleteShopInformation(Integer shopId) {
        TblShopPo shopPo = shopMapper.queryStoreInformation(shopId);
        String token = request.getHeader("token");
        String wx = HttpUtil.getWX(token);
        if ("".equals(wx)) {
            Integer curUserId = HttpUtil.getCurUserId(token);
            Integer userId = shopPo.getUserId();
            Assert.isTrue(shopPo.getUserId().equals(curUserId), "您不是该店铺的创始人，请联系创始人或程序客户人员");
            if (shopPo.getUserId().equals(curUserId)) {
                shopMapper.deleteShop(shopId);
                return true;
            }
        } else {
            Integer wxUserId = HttpUtil.getWXUserId(token);
            Integer userId = shopMapper.queryUserId(wxUserId);
            Assert.isTrue(shopPo.getUserId().equals(userId), "您不是该店铺的创始人，请联系创始人或程序客户人员");
            if (shopPo.getUserId().equals(userId)) {
                shopMapper.deleteShop(shopId);
                return true;
            }
        }
        return false;
    }
}
