package com.yingtongquan.system.equipment.mapper;

import com.yingtongquan.system.equipment.entity.TblEquipmentPrinterModelPo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
@Mapper
public interface TblEquipmentPrinterModelMapper extends BaseMapper<TblEquipmentPrinterModelPo> {

    /**
     * @Date 2020/6/14 16:15
     * @Author 胖
     * 添加打印机信息表
     **/
    Boolean addPrinterModel(TblEquipmentPrinterModelPo equipmentPrinterModelPo);

    /**
     * @Date 2020/6/14 17:28
     * @Author 胖
     * 修改店铺打印机
     **/
    Boolean updateShopPrinter(String printerName, Integer papeSize, Integer state, Integer id);

    /**
     * @Date 2020/6/14 18:01
     * @Author 胖
     * 删除店铺打印机
     **/
    Boolean deleteShopPrinter(Integer modelId);
}
