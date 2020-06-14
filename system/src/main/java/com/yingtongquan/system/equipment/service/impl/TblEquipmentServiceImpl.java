package com.yingtongquan.system.equipment.service.impl;

import com.yingtongquan.startcommon.util.HttpUtil;
import com.yingtongquan.system.equipment.entity.TblEquipmentPo;
import com.yingtongquan.system.equipment.mapper.TblEquipmentMapper;
import com.yingtongquan.system.equipment.pojo.DeleteEquipment;
import com.yingtongquan.system.equipment.pojo.ShopEquipment;
import com.yingtongquan.system.equipment.pojo.UpdateEquipment;
import com.yingtongquan.system.equipment.service.TblEquipmentPdaService;
import com.yingtongquan.system.equipment.service.TblEquipmentPrinterService;
import com.yingtongquan.system.equipment.service.TblEquipmentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.system.equipment.service.TblPhonePdaService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ML
 * @since 2020-06-14
 */
@Service
public class TblEquipmentServiceImpl extends ServiceImpl<TblEquipmentMapper, TblEquipmentPo> implements TblEquipmentService {

    @Resource
    private HttpServletRequest request;
    @Resource
    private TblEquipmentMapper equipmentMapper;
    @Resource
    private TblEquipmentPdaService equipmentPdaService;
    @Resource
    private TblEquipmentPrinterService equipmentPrinterService;
    @Resource
    private TblPhonePdaService phonePdaService;

    @Override
    public Boolean addShopEquipment(ShopEquipment shopEquipment) {
        String token = request.getHeader("token");
        Integer shopId = HttpUtil.getShopId(token);
        Integer staffId = equipmentMapper.queryStaffId(HttpUtil.getCurUserId(token));
        TblEquipmentPo equipmentPo = new TblEquipmentPo();
        equipmentPo.setName(shopEquipment.getName());
        equipmentPo.setShopId(shopId);
        equipmentPo.setStaffId(staffId);
        equipmentPo.setType(shopEquipment.getType());
        Boolean equipment = equipmentMapper.addShopEquipment(equipmentPo);
        // 店铺电话设备
        Boolean phone = false;
        // 店铺PDA
        Boolean PDA = false;
        // 店铺打印机
        Boolean printer = false;
        // 店铺无人售货机
        Boolean vendingMachine;
        if (shopEquipment.getType() == 0) {       //手机设备
            phone = phonePdaService.addPhoneEquipment(equipmentPo.getId(), shopEquipment.getPhoneState(), shopEquipment.getPhoneMac());
        }
        if (shopEquipment.getType() == 1) {       //PDA设备
            PDA = equipmentPdaService.addShopPDA(equipmentPo.getId(), shopEquipment.getPDAState(), shopEquipment.getPDAMac());
        }
        if (shopEquipment.getType() == 2) {       //打印机设备
            printer = equipmentPrinterService.addShopPrinter(shopEquipment.getPrinter(), equipmentPo.getId());
        }
        if (shopEquipment.getType() == 3) {       //自动售货机设备(不慌   以后再说)

        }
        if ((equipment && phone) || (equipment && PDA) || (equipment && printer)) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean updateShopEquipment(UpdateEquipment updateEquipment) {
        // 店铺电话设备
        Boolean phone = false;
        // 店铺PDA
        Boolean PDA = false;
        // 店铺打印机
        Boolean printer = false;
        Boolean flag = equipmentMapper.updateShopEquipment(updateEquipment);
        if (updateEquipment.getType() == 0) {
            phone = phonePdaService.updatePhoneEquipment(updateEquipment.getId(), updateEquipment.getPhoneState());
        } else if (updateEquipment.getType() == 1) {
            PDA = equipmentPdaService.updateShopPDA(updateEquipment.getId(), updateEquipment.getPDAState());
        } else if (updateEquipment.getType() == 2) {
            printer = equipmentPrinterService.updateShopPrinter(updateEquipment.getPrinterName(), updateEquipment.getPaperSize(), updateEquipment.getPrinterState(), updateEquipment.getId());
        } else if (updateEquipment.getType() == 3) {

        }
        if ((flag && phone) || (flag && PDA) || (flag && printer)) {
            return true;
        }
        return false;
    }

    @Override
    public Boolean deleteShopEquipment(DeleteEquipment deleteEquipment) {

        //todo   回家继续
        // 店铺电话设备
        Boolean phone = false;
        // 店铺PDA
        Boolean PDA = false;
        // 店铺打印机
        Boolean printer = false;
        Boolean flag = equipmentMapper.deleteShopEquipment(deleteEquipment);
        if (deleteEquipment.getType() == 0) {
            phone = phonePdaService.deletePhoneEquipment(deleteEquipment.getEquipmentId());
        } else if (deleteEquipment.getType() == 1) {
            PDA = equipmentPdaService.deleteShopPDA(deleteEquipment.getEquipmentId());
        } else if (deleteEquipment.getType() == 2) {
            printer = equipmentPrinterService.deleteShopPrinter(deleteEquipment.getEquipmentId());
        } else if (deleteEquipment.getType() == 3) {

        }
        if ((flag && phone) || (flag && PDA) || (flag && printer)) {
            return true;
        }
        return false;
    }
}
