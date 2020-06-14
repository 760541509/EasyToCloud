package com.yingtongquan.system.equipment.service;

import com.yingtongquan.system.equipment.entity.TblEquipmentPdaPo;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
public interface TblEquipmentPdaService extends IService<TblEquipmentPdaPo> {

    /**
     * @Date 2020/6/14 15:54
     * @Author 胖
     * 添加店铺PDA
     **/
    Boolean addShopPDA(Integer equipmentId,Integer state,String MAC);

    /**
     * @Date 2020/6/14 17:26
     * @Author 胖
     * 修改店铺PDA
     **/
    Boolean updateShopPDA(Integer equipmentId,Integer state);

    /**
     * @Date 2020/6/14 17:58
     * @Author 胖
     * 删除店铺PDA
     **/
    Boolean deleteShopPDA(Integer equipmentId);
}
