package com.yingtongquan.system.equipment.service.impl;

import cn.hutool.core.lang.Assert;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.yingtongquan.startcommon.util.TimeUtil;
import com.yingtongquan.system.equipment.entity.TblEquipmentPrinterPo;
import com.yingtongquan.system.equipment.mapper.TblEquipmentPrinterMapper;
import com.yingtongquan.system.equipment.pojo.Printer;
import com.yingtongquan.system.equipment.pojo.ShopEquipment;
import com.yingtongquan.system.equipment.service.TblEquipmentPrinterModelService;
import com.yingtongquan.system.equipment.service.TblEquipmentPrinterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yingtongquan.system.printer.entity.PrinterPo;
import com.yingtongquan.system.printer.servcie.PrinterService;
import com.yingtongquan.system.util.PrinterUtil;
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
public class TblEquipmentPrinterServiceImpl extends ServiceImpl<TblEquipmentPrinterMapper, TblEquipmentPrinterPo> implements TblEquipmentPrinterService {

    //有效期期时间(毫秒)
    private static final Long EXPIRE_TIME = 2592000000L;

    @Resource
    private TblEquipmentPrinterMapper equipmentPrinterMapper;
    @Resource
    private TblEquipmentPrinterModelService equipmentPrinterModelService;
    @Resource
    private PrinterService printerService;

    @Override
    public Boolean addShopPrinter(Printer printer, Integer equipmentId) {
        Integer printerModelID = equipmentPrinterModelService.addPrinterModel(printer);
        if (printerModelID == 0) {
            return false;
        }
        //添加打印机信息表
        TblEquipmentPrinterPo equipmentPrinterPo = new TblEquipmentPrinterPo();
        equipmentPrinterPo.setCheckCode(printer.getCheckCode());
        equipmentPrinterPo.setEquipmentId(equipmentId);
        equipmentPrinterPo.setMac3(printer.getMac3());
        equipmentPrinterPo.setMac4(printer.getMac4());
        equipmentPrinterPo.setMakeCoding(printer.getMakeCoding());
        equipmentPrinterPo.setModelId(printerModelID);
        Boolean flag = equipmentPrinterMapper.addShopPrinter(equipmentPrinterPo);
        if (flag) {
            PrinterUtil.bindPrinter(printer.getCheckCode(), printer.getMakeCoding(), getToken());
        }
        return equipmentPrinterMapper.addShopPrinter(equipmentPrinterPo);
    }

    @Override
    public Boolean updateShopPrinter(String printerName, Integer papeSize, Integer state, Integer equipmentId) {
        TblEquipmentPrinterPo equipmentPrinterPo = equipmentPrinterMapper.queryEquipmentInformation(equipmentId);
        return equipmentPrinterModelService.updateShopPrinter(printerName, papeSize, state, equipmentPrinterPo.getModelId());
    }

    @Override
    public Boolean deleteShopPrinter(Integer equipmentId,String printerCode) {
        TblEquipmentPrinterPo equipmentPrinterPo = equipmentPrinterMapper.queryEquipmentInformation(equipmentId);
        Boolean flag = equipmentPrinterModelService.deleteShopPrinter(equipmentPrinterPo.getModelId());
        if (flag) {
            equipmentPrinterMapper.deleteShopPrinter(equipmentId);
            PrinterUtil.unbindPrinter(printerCode,getToken());
            return true;
        }
        return false;
    }

    /**
     * @Date 2020/6/14 17:52
     * @Author 胖
     * 获取token
     **/
    private String getToken() {
        String token = null;
        PrinterPo printerPo = printerService.queryToken();
        if (printerPo != null) {
            if ((printerPo.getAddTime() + EXPIRE_TIME) > System.currentTimeMillis()) {
                token = printerPo.getToken();
            } else {
                String resu = PrinterUtil.getAccessToken();
                JSONObject result = JSONUtil.parseObj(resu);
                if ("0".equals(String.valueOf(result.get("return_code")))) {
                    JSONObject data = JSONUtil.parseObj(result.get("return_data"));
                    PrinterPo printerPojo = new PrinterPo();
                    printerPojo.setToken(String.valueOf(data.get("access_token")));
                    printerPojo.setAddTime(TimeUtil.timeConversionMilliseconds(String.valueOf(data.get("create_time"))));
                    printerService.addPrinterToken(printerPojo);
                    token = String.valueOf(data.get("access_token"));
                }
            }
        } else {
            String resu = PrinterUtil.getAccessToken();
            JSONObject result = JSONUtil.parseObj(resu);
            if ("0".equals(String.valueOf(result.get("return_code")))) {
                JSONObject data = JSONUtil.parseObj(result.get("return_data"));
                PrinterPo printerPojo = new PrinterPo();
                printerPojo.setToken(String.valueOf(data.get("access_token")));
                printerPojo.setAddTime(TimeUtil.timeConversionMilliseconds(String.valueOf(data.get("create_time"))));
                printerService.addPrinterToken(printerPojo);
                token = String.valueOf(data.get("access_token"));
            }
        }
        return token;
    }
}
