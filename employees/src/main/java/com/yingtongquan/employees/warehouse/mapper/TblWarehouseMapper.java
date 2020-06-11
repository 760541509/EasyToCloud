package com.yingtongquan.employees.warehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.warehouse.entity.TblWarehousePo;
import com.yingtongquan.employees.warehouse.pojo.ShopWarehouseGoodsArea;
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
public interface TblWarehouseMapper extends BaseMapper<TblWarehousePo> {

    /**
     * @Date 2020/5/21 16:02
     * @Author 胖
     * 添加店铺仓库
     **/
    void addShopWarehouse(TblWarehousePo warehousePo);

    /**
     * @Date 2020/5/23 15:43
     * @Author 胖
     * 查询所有的仓库
     **/
    List<ShopWarehouseGoodsArea> queryShopAllWarehouse(Integer shopId);

    /**
     * @Date 2020/5/23 15:52
     * @Author 胖
     * 修改仓库信息
     **/
    Boolean updateShopWarehouse(TblWarehousePo warehousePo);

    /**
     * @Date 2020/5/23 16:17
     * @Author 胖
     * 删除仓库信息
     **/
    Boolean deleteShopWarehouse(Integer id);

    /**
     * @Date 2020/5/23 16:20
     * @Author 胖
     * 根据仓库ID查询仓库信息
     **/
    TblWarehousePo queryWarehouseInformation(Integer id);









}
