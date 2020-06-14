package com.yingtongquan.system.equipment.service.impl;

import com.yingtongquan.system.equipment.entity.TblEquipmentPdaPo;
import com.yingtongquan.system.equipment.mapper.TblEquipmentPdaMapper;
import com.yingtongquan.system.equipment.service.TblEquipmentPdaService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
@Service
public class TblEquipmentPdaServiceImpl extends ServiceImpl<TblEquipmentPdaMapper, TblEquipmentPdaPo> implements TblEquipmentPdaService {

    @Resource
    private TblEquipmentPdaMapper equipmentPdaMapper;

    @Override
    public Boolean addShopPDA(Integer equipmentId, Integer state, String MAC) {
        TblEquipmentPdaPo equipmentPdaPo = new TblEquipmentPdaPo();
        equipmentPdaPo.setEquipmentId(equipmentId);
        equipmentPdaPo.setMac(MAC);
        if (state != null) {
            equipmentPdaPo.setState(state);
        } else {
            equipmentPdaPo.setState(0);
        }
        return equipmentPdaMapper.addShopPDA(equipmentPdaPo);
    }

    @Override
    public Boolean updateShopPDA(Integer equipmentId, Integer state) {

        return equipmentPdaMapper.updateShopPDA(equipmentId, state);
    }

    @Override
    public Boolean deleteShopPDA(Integer equipmentId) {

        return equipmentPdaMapper.deleteShopPDA(equipmentId);
    }
}
