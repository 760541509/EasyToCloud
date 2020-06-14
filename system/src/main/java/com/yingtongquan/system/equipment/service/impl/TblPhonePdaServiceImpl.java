package com.yingtongquan.system.equipment.service.impl;

import com.yingtongquan.system.equipment.entity.TblPhonePdaPo;
import com.yingtongquan.system.equipment.mapper.TblPhonePdaMapper;
import com.yingtongquan.system.equipment.service.TblPhonePdaService;
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
public class TblPhonePdaServiceImpl extends ServiceImpl<TblPhonePdaMapper, TblPhonePdaPo> implements TblPhonePdaService {

    @Resource
    private TblPhonePdaMapper phonePdaMapper;

    @Override
    public Boolean addPhoneEquipment(Integer equipmentId, Integer state, String MAC) {
        TblPhonePdaPo phonePdaPo = new TblPhonePdaPo();
        phonePdaPo.setEquipmentId(equipmentId);
        phonePdaPo.setMac(MAC);
        if (state != null) {
            phonePdaPo.setState(state);
        } else {
            phonePdaPo.setState(0);
        }
        return phonePdaMapper.addShopPhoneEquipment(phonePdaPo);
    }

    @Override
    public Boolean updatePhoneEquipment(Integer equipmentId, Integer state) {
        return phonePdaMapper.updatePhoneEquipment(state, equipmentId);
    }

    @Override
    public Boolean deletePhoneEquipment(Integer equipmentId) {
        return phonePdaMapper.deletePhoneEquipment(equipmentId);
    }

}
