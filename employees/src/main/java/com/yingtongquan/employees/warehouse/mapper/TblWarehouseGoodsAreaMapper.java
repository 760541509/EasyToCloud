package com.yingtongquan.employees.warehouse.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.yingtongquan.employees.warehouse.entity.TblWarehouseGoodsAreaPo;
import com.yingtongquan.employees.warehouse.pojo.WarehouseArea;
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
public interface TblWarehouseGoodsAreaMapper extends BaseMapper<TblWarehouseGoodsAreaPo> {

    /**
     * @Date 2020/5/23 16:36
     * @Author 胖
     * 添加仓库商品区域
     **/
    Boolean addWarehouseGoodsArea(TblWarehouseGoodsAreaPo warehouseGoodsAreaPo);

    /**
     * @Date 2020/5/23 16:36
     * @Author 胖
     * 删除仓库商品区域
     **/
    Boolean deleteWarehouseGoodsArea(Integer warehouseId);

    /**
     * @Date 2020/5/23 16:36
     * @Author 胖
     * 修改仓库商品区域
     **/
    Boolean updateWarehouseGoodsArea(WarehouseArea warehouseArea);

    /**
     * @Date 2020/5/23 16:36
     * @Author 胖
     * 查询所有的仓库商品区域
     **/
    List<WarehouseArea> queryAllWarehouseGoodsArea(Integer warehouseId);

}
