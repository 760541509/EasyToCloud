package com.yingtongquan.employees.goods.service.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.employees.goods.entity.*;
import com.yingtongquan.employees.goods.entity.TblGoodsSpuPo.*;
import com.yingtongquan.employees.goods.mapper.*;
import com.yingtongquan.employees.goods.pojo.GoodsPricePoCallClient;
import com.yingtongquan.employees.goods.service.TblGoodsSpuService;
import com.yingtongquan.employees.goodsShopClassify.entity.TblShopGoodsClassifyPo;
import com.yingtongquan.employees.goodsShopClassify.mapper.TblShopGoodsClassifyMapper;
import com.yingtongquan.startcommon.util.HttpUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-05-29
 */
@Service
public class TblGoodsSpuServiceImpl extends ServiceImpl<TblGoodsSpuMapper, TblGoodsSpuPo> implements TblGoodsSpuService {

    @Resource
    private TblGoodsSpuMapper mapper;
    @Resource
    private TblShopGoodsMapper shopGoodsMapper;
    @Resource
    private TblWarehouseGoodsMapper warehouseGoodsMapper;
    @Resource
    private TblShopGoodsClassifyMapper shopGoodsClassifyMapper;
    @Resource
    private TblGoodsSkuMapper goodsSkuMapper;
    @Resource
    private TblGoodsSkuSpecValueMapper goodsSkuSpecValueMapper;
    @Resource
    private TblGoodsSpuUnitMapper goodsSpuUnitMapper;
    @Resource
    private TblGoodsPriceMapper goodsPriceMapper;
    @Resource
    private TblWarehouseGoodsSkuStoreMapper warehouseGoodsSkuStoreMapper;
    @Resource
    private TblShopGoodsSkuStoreMapper shopGoodsSkuStoreMapper;

    @Resource
    private HttpServletRequest request;

    @Override
    public Boolean addInfo(TblGoodsSpuPoAddPa info) {

        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);
        Integer staffId = HttpUtil.getStaffId(token);

        long time = System.currentTimeMillis();

        info.setFkStaffId(staffId);
        info.setFkShopId(shopId);
        info.setAddTime(time);
        info.setUpTime(time);
        info.setTotalStore(0);
        info.setMonthlySales(0);

        //填充最高价和最低价


        info.getGoodsSkuList().forEach(tblGoodsSkuPoAddPa -> {

            Map<Integer, List<TblGoodsPricePo.TblGoodsPricePoAddPa>> unitPriceMapList = new HashMap();


            tblGoodsSkuPoAddPa.getUnitPriceList().forEach(new Consumer<TblGoodsPricePo.TblGoodsPricePoAddPa>() {
                @Override
                public void accept(TblGoodsPricePo.TblGoodsPricePoAddPa tblGoodsPricePoAddPa) {
                    List<TblGoodsPricePo.TblGoodsPricePoAddPa> itemV = unitPriceMapList.get(tblGoodsPricePoAddPa.getFkMemberPriceShopId());
                    if (itemV != null) {
                        itemV.add(tblGoodsPricePoAddPa);
                    } else {
                        itemV = new ArrayList<>();
                        itemV.add(tblGoodsPricePoAddPa);
                        unitPriceMapList.put(tblGoodsPricePoAddPa.getFkMemberPriceShopId(), itemV);
                    }

                }
            });

            unitPriceMapList.forEach(new BiConsumer<Integer, List<TblGoodsPricePo.TblGoodsPricePoAddPa>>() {
                @Override
                public void accept(Integer integer, List<TblGoodsPricePo.TblGoodsPricePoAddPa> tblGoodsPricePoAddPas) {
                    if (info.getUnitList().size() != tblGoodsPricePoAddPas.size()) {
                        throw new IllegalArgumentException(StrUtil.format("商品对应的价格有误"));
                    }
                }
            });


        });


        //是否选择了分类
        if (info.getFkGoodsCsId() != null) {
            //查询平台的分类
            TblShopGoodsClassifyPo.TblShopGoodsClassifyPoGetPa shopGoodsClassifyPoGetPa = new TblShopGoodsClassifyPo.TblShopGoodsClassifyPoGetPa();
            shopGoodsClassifyPoGetPa.setId(info.getFkGoodsCsId());
            TblShopGoodsClassifyPo shopGoodsClassifyPo = shopGoodsClassifyMapper.getByInfo(shopGoodsClassifyPoGetPa);
            if (shopGoodsClassifyPo != null) {
                info.setFkGoodsCpId(shopGoodsClassifyPo.getFkGoodsCpId());
            }
        }

        //新增商品spu信息
        Boolean mapperAddInfo = mapper.addInfo(info);
        if (!mapperAddInfo) {
            throw new IllegalArgumentException(StrUtil.format("发布商品出错了."));
        }
        //关联到门店
        TblShopGoodsPo.TblShopGoodsPoAddPa shopGoodsPoAddPa = new TblShopGoodsPo.TblShopGoodsPoAddPa();
        shopGoodsPoAddPa.setDistributorCommissionRate(0);
        shopGoodsPoAddPa.setStaffCommissionRate(0);
        shopGoodsPoAddPa.setFkFareTemplateId(0);
        shopGoodsPoAddPa.setFkGoodsCsId(info.getFkGoodsCsId());
        shopGoodsPoAddPa.setFkGoodsSpuId(info.getId());
        shopGoodsPoAddPa.setFkShopId(info.getFkShopId());
        Boolean shopGoodsMapperAddInfo = shopGoodsMapper.addInfo(shopGoodsPoAddPa);
        if (!shopGoodsMapperAddInfo) {
            throw new IllegalArgumentException(StrUtil.format("发布商品出错了.."));
        }

        //关联到仓库
        if (info.getWarehouseList() != null && info.getWarehouseList().size() > 0) {
            info.getWarehouseList().forEach(warehouseGoodsPoAddPa -> {
                warehouseGoodsPoAddPa.setDistributorCommissionRate(0);
                warehouseGoodsPoAddPa.setStaffCommissionRate(0);
                warehouseGoodsPoAddPa.setFkFareTemplateId(0);
                warehouseGoodsPoAddPa.setFkGoodsWarehouseAreaId(0);
                warehouseGoodsPoAddPa.setFkGoodsSpuId(info.getId());
            });
            Boolean warehouseGoodsMapperMapperAddInfo = warehouseGoodsMapper.addBatchInfo(info.getWarehouseList());
            if (!warehouseGoodsMapperMapperAddInfo) {
                throw new IllegalArgumentException(StrUtil.format("发布商品出错了..."));
            }
        }


        //新增商品sku 信息
        info.getGoodsSkuList().forEach(tblGoodsSkuPoAddPa -> {
            tblGoodsSkuPoAddPa.setFkGoodsSpuId(info.getId());
            tblGoodsSkuPoAddPa.setStore(0);
        });
        Boolean goodsSkuMapperAddBatchInfo = goodsSkuMapper.addBatchInfo(info.getGoodsSkuList());
        if (!goodsSkuMapperAddBatchInfo) {
            throw new IllegalArgumentException(StrUtil.format("新增商品sku出错了.."));
        }

        //新增商品sku 的规格值
        List<TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoAddPa> goodsSkuSpecValuePoAddPaList = new ArrayList<>();
        info.getGoodsSkuList().forEach(tblGoodsSkuPoAddPa -> {
            List<Integer> specValueIds = JSON.parseArray(tblGoodsSkuPoAddPa.getFkSpecValueIds(), Integer.class);
            specValueIds.forEach(integer -> {
                TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoAddPa goodsSkuSpecValuePoAddPa = new TblGoodsSkuSpecValuePo.TblGoodsSkuSpecValuePoAddPa();
                goodsSkuSpecValuePoAddPa.setFkGoodsSkuId(tblGoodsSkuPoAddPa.getId());
                goodsSkuSpecValuePoAddPa.setFkSpecValueId(integer);
                goodsSkuSpecValuePoAddPaList.add(goodsSkuSpecValuePoAddPa);
            });
        });
        if (!goodsSkuSpecValuePoAddPaList.isEmpty()) {
            Boolean goodsSkuSpecValueMapperAddBatchInfo = goodsSkuSpecValueMapper.addBatchInfo(goodsSkuSpecValuePoAddPaList);
            if (!goodsSkuSpecValueMapperAddBatchInfo) {
                throw new IllegalArgumentException(StrUtil.format("新增商品sku规格值出错了.."));
            }
        }


        //新增商品单位信息
        addGoodsUnit(info);

        //新增sku的价格和库存
        addGoodsPriceAndStore(info);

        return true;
    }

    /**
     * 入库到门店
     * @param info
     * @return
     */
    @Override
    public Boolean addShopGoodsSkuStore(List<TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa> info) {

        Boolean addBatchInfo = false;

        if (!info.isEmpty()) {
            String token = request.getHeader("token");
            Integer shopId = HttpUtil.getShopId(token);
            Integer staffId = HttpUtil.getStaffId(token);
            long time = System.currentTimeMillis();
            info.forEach(tblShopGoodsSkuStorePoAddPa -> {
                tblShopGoodsSkuStorePoAddPa.setAddTime(time);
                tblShopGoodsSkuStorePoAddPa.setFkIdStaff(staffId);
                tblShopGoodsSkuStorePoAddPa.setFkShopId(shopId);
            });
            addBatchInfo = shopGoodsSkuStoreMapper.addBatchInfo(info);

           if(addBatchInfo){
               upGoodsSkuStore(null,info);
           }
        }

        return addBatchInfo;
    }


    /**
     * 入库到仓库
     * @param info
     * @return
     */
    @Override
    public Boolean addWarehouseGoodsSkuStore(List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> info) {

        Boolean addBatchInfo = false;

        if (!info.isEmpty()) {

            String token = request.getHeader("token");
            Integer staffId = HttpUtil.getStaffId(token);
            long time = System.currentTimeMillis();

            info.forEach(tblWarehouseGoodsSkuStorePoAddPa -> {
                tblWarehouseGoodsSkuStorePoAddPa.setFkIdStaff(staffId);
                tblWarehouseGoodsSkuStorePoAddPa.setAddTime(time);
            });

            addBatchInfo = warehouseGoodsSkuStoreMapper.addBatchInfo(info);

            if(addBatchInfo){
                upGoodsSkuStore(info,null);
            }

        }

        return addBatchInfo;
    }

    /**
     * 修改sku 的库存
     * @param warehouseGoodsSkuStorePoAddPaList
     * @param shopGoodsSkuStorePoAddPaList
     */
    private void upGoodsSkuStore(List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> warehouseGoodsSkuStorePoAddPaList,
                                 List<TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa> shopGoodsSkuStorePoAddPaList){

        List<Integer> ids = new ArrayList<>();
        Map<Integer,Integer> mapInfo = new HashMap<>();

        //仓库
        if(warehouseGoodsSkuStorePoAddPaList!=null){
            warehouseGoodsSkuStorePoAddPaList.forEach(tblWarehouseGoodsSkuStorePoAddPa -> {
                ids.add(tblWarehouseGoodsSkuStorePoAddPa.getFkGoodsSkuId());
                mapInfo.put(tblWarehouseGoodsSkuStorePoAddPa.getFkGoodsSkuId(),tblWarehouseGoodsSkuStorePoAddPa.getStore());
            });
        }
        //门店
        else if(shopGoodsSkuStorePoAddPaList!=null){
            shopGoodsSkuStorePoAddPaList.forEach(tblShopGoodsSkuStorePoAddPa -> {
                ids.add(tblShopGoodsSkuStorePoAddPa.getFkGoodsSkuId());
                mapInfo.put(tblShopGoodsSkuStorePoAddPa.getFkGoodsSkuId(),tblShopGoodsSkuStorePoAddPa.getStore());
            });
        }

        List<TblGoodsSkuPo> goodsSkuPoList = goodsSkuMapper.getListByGoodsSkuIds(ids);

//        System.out.println("mapInfo==="+JSON.toJSON(mapInfo));
//        System.out.println("goodsSkuPoList==="+JSON.toJSON(goodsSkuPoList));

        goodsSkuPoList.forEach(tblGoodsSkuPo -> {
            Integer store = tblGoodsSkuPo.getStore()+mapInfo.get(tblGoodsSkuPo.getId());
            tblGoodsSkuPo.setStore(store);
        });

        //修改库存
        Boolean goodsSkuMapperUpdateStoreBatch = goodsSkuMapper.updateStoreBatchInfo(goodsSkuPoList);
        System.out.println("修改库存===="+goodsSkuMapperUpdateStoreBatch);
    }


    /**
     * 新增单位
     */
    private void addGoodsUnit(TblGoodsSpuPoAddPa info) {
        List<TblGoodsSpuUnitPo.TblGoodsSpuUnitPoAddPa> unitList = info.getUnitList();
        //先新增第一个商品单位
        if (unitList.size() > 0) {
            TblGoodsSpuUnitPo.TblGoodsSpuUnitPoAddPa goodsSpuUnitPo = unitList.get(0);
            goodsSpuUnitPo.setSupId(0);
            goodsSpuUnitPo.setFkGoodsSpuId(info.getId());
            Boolean isGoodsSpuUnitMapperAdd = goodsSpuUnitMapper.addInfo(goodsSpuUnitPo);
            if (!isGoodsSpuUnitMapperAdd) {
                throw new IllegalArgumentException(StrUtil.format("新增商品单位出错了."));
            }

            if (unitList.size() > 1) {
                for (int i = 1; i < unitList.size(); i++) {
                    TblGoodsSpuUnitPo.TblGoodsSpuUnitPoAddPa goodsSpuUnitPoItem = unitList.get(i);
                    goodsSpuUnitPoItem.setFkGoodsSpuId(info.getId());
                    goodsSpuUnitPoItem.setSupId(goodsSpuUnitPo.getId());
                    Boolean isItemAdd = goodsSpuUnitMapper.addInfo(goodsSpuUnitPoItem);
                    if (!isItemAdd) {
                        throw new IllegalArgumentException(StrUtil.format("新增商品单位出错了.."));
                    }
                }
            }
        }
    }

    /**
     * 填充sku的价格和库存
     */
    private void addGoodsPriceAndStore(TblGoodsSpuPoAddPa info) {


        //商品价格表
        List<TblGoodsPricePo.TblGoodsPricePoAddPa> goodsPricePoAddPaList = new ArrayList<>();
        //仓库库存表
        List<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa> warehouseGoodsstoreList = new ArrayList<>();
        //门店库存表
        List<TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa> shopGoodsstoreList = new ArrayList<>();

        info.getGoodsSkuList().forEach(new Consumer<TblGoodsSkuPo.TblGoodsSkuPoAddPa>() {
            @Override
            public void accept(TblGoodsSkuPo.TblGoodsSkuPoAddPa tblGoodsSkuPoAddPa) {
                tblGoodsSkuPoAddPa.setFkGoodsSpuId(info.getId());


                //价格
                if (null != tblGoodsSkuPoAddPa.getUnitPriceList()) {

                    //价格数据
                    Map<Integer, List<TblGoodsPricePo.TblGoodsPricePoAddPa>> unitPriceMapList = new HashMap();

                    tblGoodsSkuPoAddPa.getUnitPriceList().forEach(new Consumer<TblGoodsPricePo.TblGoodsPricePoAddPa>() {
                        @Override
                        public void accept(TblGoodsPricePo.TblGoodsPricePoAddPa tblGoodsPricePoAddPa) {
                            List<TblGoodsPricePo.TblGoodsPricePoAddPa> itemV = unitPriceMapList.get(tblGoodsPricePoAddPa.getFkMemberPriceShopId());
                            if (itemV != null) {
                                itemV.add(tblGoodsPricePoAddPa);
                            } else {
                                itemV = new ArrayList<>();
                                itemV.add(tblGoodsPricePoAddPa);
                                unitPriceMapList.put(tblGoodsPricePoAddPa.getFkMemberPriceShopId(), itemV);
                            }
                        }
                    });

                    //赋值单位id
                    unitPriceMapList.forEach((key, maps) -> {

                        for (int i = 0; i < maps.size(); i++) {
                            TblGoodsPricePo.TblGoodsPricePoAddPa item = maps.get(i);
                            item.setFkGoodsSpuId(info.getId());
                            item.setFkGoodsSkuId(tblGoodsSkuPoAddPa.getId());
                            item.setFkGoodsSpuUnitId(info.getUnitList().get(i).getId());

                            goodsPricePoAddPaList.add(item);
                        }
                    });
                }


                //仓库库存
                if (null != tblGoodsSkuPoAddPa.getWarehouseGoodsstoreList()) {
                    tblGoodsSkuPoAddPa.getWarehouseGoodsstoreList().forEach(new Consumer<TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa>() {
                        @Override
                        public void accept(TblWarehouseGoodsSkuStorePo.TblWarehouseGoodsSkuStorePoAddPa tblWarehouseGoodsSkuStorePoAddPa) {
                            tblWarehouseGoodsSkuStorePoAddPa.setFkIdStaff(info.getFkStaffId());
                            tblWarehouseGoodsSkuStorePoAddPa.setAddTime(System.currentTimeMillis());
                            tblWarehouseGoodsSkuStorePoAddPa.setFkGoodsSkuId(tblGoodsSkuPoAddPa.getId());
                            tblWarehouseGoodsSkuStorePoAddPa.setStore(tblWarehouseGoodsSkuStorePoAddPa.getStore() == null ? 0 : tblWarehouseGoodsSkuStorePoAddPa.getStore());
                        }
                    });
                    warehouseGoodsstoreList.addAll(tblGoodsSkuPoAddPa.getWarehouseGoodsstoreList());
                }


                //门店库存
                TblShopGoodsSkuStorePo.TblShopGoodsSkuStorePoAddPa shopGoodsSkuStorePoAddPa = tblGoodsSkuPoAddPa.getShopGoodsstore();
                if (shopGoodsSkuStorePoAddPa != null) {
                    shopGoodsSkuStorePoAddPa.setFkIdStaff(info.getFkStaffId());
                    shopGoodsSkuStorePoAddPa.setAddTime(System.currentTimeMillis());
                    shopGoodsSkuStorePoAddPa.setFkGoodsSkuId(tblGoodsSkuPoAddPa.getId());
                    shopGoodsstoreList.add(shopGoodsSkuStorePoAddPa);
                }

            }
        });

        //新增价格
        if (!goodsPricePoAddPaList.isEmpty()) {
            Boolean goodsPriceMapperAddBatchInfo = goodsPriceMapper.addBatchInfo(goodsPricePoAddPaList);
            if (!goodsPriceMapperAddBatchInfo) {
                throw new IllegalArgumentException(StrUtil.format("新增商品价格出错了.."));
            }
        }

        //仓库库存表
        if (!warehouseGoodsstoreList.isEmpty()) {
            Boolean warehouseGoodsSkuStoreMapperAddBatchInfo = warehouseGoodsSkuStoreMapper.addBatchInfo(warehouseGoodsstoreList);
            if (!warehouseGoodsSkuStoreMapperAddBatchInfo) {
                throw new IllegalArgumentException(StrUtil.format("新增商品仓库库存出错了.."));
            }
        }

        //门店库存表
        if (!shopGoodsstoreList.isEmpty()) {
            Boolean shopGoodsSkuStoreMapperAddBatchInfo = shopGoodsSkuStoreMapper.addBatchInfo(shopGoodsstoreList);
            if (!shopGoodsSkuStoreMapperAddBatchInfo) {
                throw new IllegalArgumentException(StrUtil.format("新增商品门店库存出错了.."));
            }
        }

    }

    @Override
    public Boolean updateInfo(TblGoodsSpuPoUpPa info) {

        return mapper.updateInfo(info);
    }

    @Override
    public Boolean deleteByInfo(TblGoodsSpuPoDelPa info) {

        return mapper.deleteByInfo(info);
    }


    @Override
    public List<TblGoodsSkuPo> getSkuListByGoodsId(TblGoodsSpuPoGetPa info) {

        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);

        List<TblGoodsSkuPo> goodsSkuPoList =  getGoodsSkuList(info.getFkMemberPriceShopId(),info.getFkGoodsSpuId(),shopId);

        if (goodsSkuPoList.isEmpty()) {
            throw new IllegalArgumentException(StrUtil.format("该商品无规格信息"));
        }

        return goodsSkuPoList;
    }

    @Override
    public List<TblGoodsSpuPoCallList> getListByInfo(TblGoodsSpuPoGetListPa info) {

        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);

        List<TblGoodsSpuPoCallList> goodsSpuPoCallLists = mapper.getListByInfo(info);

        //获取sku
        goodsSpuPoCallLists.forEach(tblGoodsSpuPoCallList -> {

            //根据价格类型填充最高价和最低价
            GoodsPricePoCallClient goodsPricePo = getGoodsPricePoCallClient(info.getFkMemberPriceShopId(),tblGoodsSpuPoCallList.getFkGoodsSpuId(),shopId);
            if (goodsPricePo != null) {
                tblGoodsSpuPoCallList.setLowestPrice(goodsPricePo.getLowestPrice());
                tblGoodsSpuPoCallList.setHighestPrice(goodsPricePo.getHighestPrice());
                tblGoodsSpuPoCallList.setPriceName(goodsPricePo.getPriceName());
            }

            //填充商品的sku 规格描述
            List<TblGoodsSkuPoCallSpecDec> goodsSkuPoCallSpecDecList = mapper.getSpecDec(tblGoodsSpuPoCallList.getId());
            if (goodsSkuPoCallSpecDecList.size() > 0) {
                StringBuffer specValue = new StringBuffer();
                goodsSkuPoCallSpecDecList.forEach(tblGoodsSkuPoCallSpecDec -> {
                    if (specValue.length() != 0) {
                        specValue.append(" | ");
                    }
                    specValue.append(tblGoodsSkuPoCallSpecDec.getSpecValue());
                });
                tblGoodsSpuPoCallList.setSpecDec(specValue.toString());
            } else {
                tblGoodsSpuPoCallList.setSpecDec("无规格信息");
            }

            //填充单位
            tblGoodsSpuPoCallList.setUnitList(getGoodsSpuUnitPoList(tblGoodsSpuPoCallList.getFkGoodsSpuId()));

            //填充总库存
            Integer totalStore = getSumGoodsSkuStore(tblGoodsSpuPoCallList.getFkGoodsSpuId());
            tblGoodsSpuPoCallList.setTotalStore(totalStore);

        });


        return goodsSpuPoCallLists;
    }


    @Override
    public TblGoodsSpuPoCall getByInfo(TblGoodsSpuPoGetPa info) {

        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);

        TblGoodsSpuPoCall goodsSpuPoCall = mapper.getByInfo(info);



        if(goodsSpuPoCall!=null){

            info.setFkMemberPriceShopId(getDefaFkMemberPriceShopId(info.getFkMemberPriceShopId(),shopId));

            //根据价格类型填充最高价和最低价
            GoodsPricePoCallClient goodsPricePo = getGoodsPricePoCallClient(info.getFkMemberPriceShopId(),goodsSpuPoCall.getFkGoodsSpuId(),shopId);
            if (goodsPricePo != null) {
                goodsSpuPoCall.setLowestPrice(goodsPricePo.getLowestPrice());
                goodsSpuPoCall.setHighestPrice(goodsPricePo.getHighestPrice());
                goodsSpuPoCall.setPriceName(goodsPricePo.getPriceName());
            }

            //填充单位
            goodsSpuPoCall.setUnitList(getGoodsSpuUnitPoList(goodsSpuPoCall.getFkGoodsSpuId()));

            //填充总库存
            Integer totalStore = getSumGoodsSkuStore(goodsSpuPoCall.getFkGoodsSpuId());
            goodsSpuPoCall.setTotalStore(totalStore);

            //获取sku
            List<TblGoodsSkuPo> goodsSkuPoList =  getGoodsSkuList(info.getFkMemberPriceShopId(),goodsSpuPoCall.getFkGoodsSpuId(),shopId);

            System.out.println("goodsSkuPoList=============="+JSON.toJSON(goodsSkuPoList));

            goodsSpuPoCall.setGoodsSkuList(goodsSkuPoList);
        }

        return goodsSpuPoCall;
    }


    /**
     * 获取最高价和最低价
     * @return
     */
    private GoodsPricePoCallClient getGoodsPricePoCallClient(Integer fkMemberPriceShopId,Integer fkGoodsSpuId,Integer fkShopId){
        //根据价格类型填充最高价和最低价
        //查询对应的单位价格信息（默认查询零售价）
        fkMemberPriceShopId = getDefaFkMemberPriceShopId(fkMemberPriceShopId,fkShopId);

        TblGoodsPricePo.TblGoodsPricePoGetPa goodsPricePoGetPa = new TblGoodsPricePo.TblGoodsPricePoGetPa();
        goodsPricePoGetPa.setFkGoodsSpuId(fkGoodsSpuId);
        goodsPricePoGetPa.setFkMemberPriceShopId(fkMemberPriceShopId);
        return goodsPriceMapper.getPriceRangeByInfo(goodsPricePoGetPa);
    }

    /**
     * 获取商品的单位
     * @return
     */
    private List<TblGoodsSpuUnitPo> getGoodsSpuUnitPoList(Integer fkGoodsSpuId){
        TblGoodsSpuUnitPo.TblGoodsSpuUnitPoGetListPa goodsSpuUnitPoGetListPa = new TblGoodsSpuUnitPo.TblGoodsSpuUnitPoGetListPa();
        goodsSpuUnitPoGetListPa.setFkGoodsSpuId(fkGoodsSpuId);
        return goodsSpuUnitMapper.getListByInfo(goodsSpuUnitPoGetListPa);
    }

    /**
     * 获取商品总库存
     * @param fkGoodsSpuId
     * @return
     */
    private Integer getSumGoodsSkuStore(Integer fkGoodsSpuId){
        return goodsSkuMapper.sumGoodsSkuStore(fkGoodsSpuId);
    }

    /**
     * 获取商品的sku信息
     * @param fkGoodsSpuId
     * @return
     */
    private  List<TblGoodsSkuPo> getGoodsSkuList(Integer fkMemberPriceShopId,Integer fkGoodsSpuId,Integer fkShopId){

        //根据价格类型填充最高价和最低价
        fkMemberPriceShopId = getDefaFkMemberPriceShopId(fkMemberPriceShopId,fkShopId);

        System.out.println("fkMemberPriceShopId===="+fkMemberPriceShopId);
        System.out.println("fkGoodsSpuId===="+fkGoodsSpuId);

        //获取sku 信息
        TblGoodsSkuPo.TblGoodsSkuPoGetListPa goodsSkuPoGetListPa = new TblGoodsSkuPo.TblGoodsSkuPoGetListPa();
        goodsSkuPoGetListPa.setFkGoodsSpuId(fkGoodsSpuId);
        List<TblGoodsSkuPo> goodsSkuPoList = goodsSkuMapper.getListByInfo(goodsSkuPoGetListPa);

        //获取单位和价格
        TblGoodsPricePo.TblGoodsPricePoGetListPa goodsPricePoGetPa = new TblGoodsPricePo.TblGoodsPricePoGetListPa();
        goodsPricePoGetPa.setFkMemberPriceShopId(fkMemberPriceShopId);
        goodsPricePoGetPa.setFkGoodsSpuId(fkGoodsSpuId);
        List<TblGoodsPricePo> goodsPricePoList = goodsPriceMapper.getListByInfo(goodsPricePoGetPa);
        //根据sku的id 填充
        Map<Integer, List<TblGoodsPricePo>> integerListMap = new HashMap<>();
        goodsPricePoList.forEach(tblGoodsPricePo -> {
            integerListMap.computeIfAbsent(tblGoodsPricePo.getFkGoodsSkuId(), k -> new ArrayList<>());
            integerListMap.get(tblGoodsPricePo.getFkGoodsSkuId()).add(tblGoodsPricePo);
        });

        goodsSkuPoList.forEach(tblGoodsSkuPo -> tblGoodsSkuPo.setGoodsPricePoList(integerListMap.get(tblGoodsSkuPo.getId())));

        return goodsSkuPoList;
    }

    /**
     * 默认查询零售价
     * @param fkMemberPriceShopId
     * @param fkShopId
     * @return
     */
    private Integer getDefaFkMemberPriceShopId(Integer fkMemberPriceShopId,Integer fkShopId){
        if (fkMemberPriceShopId == null || fkMemberPriceShopId == 0) {
            //查询零售价对应的id
            fkMemberPriceShopId = goodsPriceMapper.getDefaFkMemberPriceShopId(fkShopId);
            if(fkMemberPriceShopId==null){
                throw new IllegalArgumentException(StrUtil.format("该门店，未查询到默认价格类型。"));
            }
        }
        return fkMemberPriceShopId;
    }

}
