package com.yingtongquan.system.equipment.service;

import com.yingtongquan.system.equipment.entity.TblEquipmentPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
public interface TblEquipmentService extends IService<TblEquipmentPo> {

    /**
     * @Date 2020/6/14 15:14
     * @Author 胖
     * 添加设备
     **/
    Boolean addShopEquipment();
}
