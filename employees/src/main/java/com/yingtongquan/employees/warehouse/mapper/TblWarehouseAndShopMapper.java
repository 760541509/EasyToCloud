package com.yingtongquan.employees.warehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.warehouse.entity.TblWarehouseAndShopPo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
public interface TblWarehouseAndShopMapper extends BaseMapper<TblWarehouseAndShopPo> {
    /**
     * @Date 2020/5/23 15:07
     * @Author 胖
     * 添加关系表
     **/
    Boolean addWarehouseAndShopRelationshipBetween(TblWarehouseAndShopPo warehouseAndShopPo);

    /**
     * @Date 2020/5/23 17:04
     * @Author 胖
     * 删除关系表
     **/
    void deleteWarehouseAndShopRelationshipBetween(TblWarehouseAndShopPo warehouseAndShopPo);
}
