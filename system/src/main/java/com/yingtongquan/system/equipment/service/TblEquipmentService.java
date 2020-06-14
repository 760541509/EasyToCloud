package com.yingtongquan.system.equipment.service;

import com.yingtongquan.system.equipment.entity.TblEquipmentPo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yingtongquan.system.equipment.pojo.DeleteEquipment;
import com.yingtongquan.system.equipment.pojo.ShopEquipment;
import com.yingtongquan.system.equipment.pojo.UpdateEquipment;

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
    Boolean addShopEquipment(ShopEquipment shopEquipment);

    /**
     * @Date 2020/6/14 17:15
     * @Author 胖
     * 修改设备
     **/
    Boolean updateShopEquipment(UpdateEquipment updateEquipment);

    /**
     * @Date 2020/6/14 17:38
     * @Author 胖
     * 删除设备
     **/
    Boolean deleteShopEquipment(DeleteEquipment deleteEquipment);

}
