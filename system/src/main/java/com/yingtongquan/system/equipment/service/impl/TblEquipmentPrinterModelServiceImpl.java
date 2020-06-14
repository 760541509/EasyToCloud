package com.yingtongquan.system.equipment.service.impl;

import com.yingtongquan.system.equipment.entity.TblEquipmentPrinterModelPo;
import com.yingtongquan.system.equipment.mapper.TblEquipmentPrinterModelMapper;
import com.yingtongquan.system.equipment.pojo.Printer;
import com.yingtongquan.system.equipment.service.TblEquipmentPrinterModelService;
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
public class TblEquipmentPrinterModelServiceImpl extends ServiceImpl<TblEquipmentPrinterModelMapper, TblEquipmentPrinterModelPo> implements TblEquipmentPrinterModelService {

    @Resource
    private TblEquipmentPrinterModelMapper equipmentPrinterModelMapper;

    @Override
    public Integer addPrinterModel(Printer printer) {
        TblEquipmentPrinterModelPo equipmentPrinterModelPo = new TblEquipmentPrinterModelPo();
        equipmentPrinterModelPo.setName(printer.getPrinterName());
        equipmentPrinterModelPo.setPaperSize(printer.getPaperSize());
        if (printer.getPrinterState() != null) {
            equipmentPrinterModelPo.setState(printer.getPrinterState());
        } else {
            equipmentPrinterModelPo.setState(0);
        }
        Boolean model = equipmentPrinterModelMapper.addPrinterModel(equipmentPrinterModelPo);
        if (model) {
            return equipmentPrinterModelPo.getId();
        }
        return 0;
    }

    @Override
    public Boolean updateShopPrinter(String printerName, Integer papeSize, Integer state, Integer id) {

        return equipmentPrinterModelMapper.updateShopPrinter(printerName, papeSize, state, id);
    }

    @Override
    public Boolean deleteShopPrinter(Integer modelId) {
        return equipmentPrinterModelMapper.deleteShopPrinter(modelId);
    }
}
