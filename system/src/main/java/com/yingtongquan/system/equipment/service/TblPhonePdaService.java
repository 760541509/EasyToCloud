package com.yingtongquan.system.equipment.service;

import com.yingtongquan.system.equipment.entity.TblPhonePdaPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
public interface TblPhonePdaService extends IService<TblPhonePdaPo> {

    /**
     * @Date 2020/6/14 15:45
     * @Author 胖
     * 添加手机设备
     **/
    Boolean addPhoneEquipment(Integer equipmentId,Integer state,String MAC);

    /**
     * @Date 2020/6/14 17:24
     * @Author 胖
     * 修改手机设备
     **/
    Boolean updatePhoneEquipment(Integer equipmentId,Integer state);

    /**
     * @Date 2020/6/14 17:56
     * @Author 胖
     * 删除手机设备
     **/
    Boolean deletePhoneEquipment(Integer equipmentId);

}
