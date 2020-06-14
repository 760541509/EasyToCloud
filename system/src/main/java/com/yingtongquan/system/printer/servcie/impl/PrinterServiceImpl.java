package com.yingtongquan.system.printer.servcie.impl;

import com.yingtongquan.system.printer.dao.PrinterDao;
import com.yingtongquan.system.printer.entity.PrinterPo;
import com.yingtongquan.system.printer.servcie.PrinterService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PrinterServiceImpl implements PrinterService {
    @Resource
    private PrinterDao printerDao;

    @Override
    public void addPrinterToken(PrinterPo printer) {
        printerDao.addPrinterToken(printer);
    }

    @Override
    public PrinterPo queryToken() {
        return printerDao.queryToken();
    }

    @Override
    public void updateToken(PrinterPo printer) {
        printerDao.updateToken(printer);
    }
}
