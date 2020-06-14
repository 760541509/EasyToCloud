package com.yingtongquan.system.equipment.mapper;

import com.yingtongquan.system.equipment.entity.TblEquipmentPrinterPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* <p>
    *  Mapper 接口
    * </p>
*
* @author ML
* @since 2020-06-14
*/
@Mapper
public interface TblEquipmentPrinterMapper extends BaseMapper<TblEquipmentPrinterPo> {

    /**
     * @Date 2020/6/14 16:20
     * @Author 胖
     * 添加打印机
     **/
    Boolean addShopPrinter(TblEquipmentPrinterPo equipmentPrinterPo);

    /**
     * @Date 2020/6/14 17:34
     * @Author 胖
     * 查询打印机信息表
     **/
    TblEquipmentPrinterPo queryEquipmentInformation(Integer equipmentId);

    /**
     * @Date 2020/6/14 17:59
     * @Author 胖
     * 删除店铺打印机
     **/
    Boolean deleteShopPrinter(Integer equipmentId);
}
