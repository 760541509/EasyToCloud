package com.yingtongquan.system.equipment.service;

import com.yingtongquan.system.equipment.entity.TblEquipmentPrinterModelPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.system.equipment.pojo.Printer;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
public interface TblEquipmentPrinterModelService extends IService<TblEquipmentPrinterModelPo> {

    /**
     * @Date 2020/6/14 16:13
     * @Author 胖
     * 添加打印机型号信息表
     **/
    Integer addPrinterModel(Printer printer);

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
