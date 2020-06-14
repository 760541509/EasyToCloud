package com.yingtongquan.system.equipment.service;

import com.yingtongquan.system.equipment.entity.TblEquipmentPrinterPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.system.equipment.pojo.Printer;
import com.yingtongquan.system.equipment.pojo.ShopEquipment;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
public interface TblEquipmentPrinterService extends IService<TblEquipmentPrinterPo> {
    /**
     * @Date 2020/6/14 16:01
     * @Author 胖
     * 添加店铺打印机
     **/
    Boolean addShopPrinter(Printer printer, Integer equipmentId);

    /**
     * @Date 2020/6/14 17:28
     * @Author 胖
     * 修改店铺打印机
     **/
    Boolean updateShopPrinter(String printerName, Integer papeSize, Integer state, Integer equipmentId);

    /**
     * @Date 2020/6/14 17:59
     * @Author 胖
     * 删除店铺打印机
     **/
    Boolean deleteShopPrinter(Integer equipmentId, String printerCode);
}
