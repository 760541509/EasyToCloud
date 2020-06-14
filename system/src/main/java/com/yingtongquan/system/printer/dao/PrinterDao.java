package com.yingtongquan.system.printer.dao;

import com.yingtongquan.system.printer.entity.PrinterPo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PrinterDao {

    /**
     * @Date 2020/6/14 16:41
     * @Author 胖
     * 添加token
     **/
    void addPrinterToken(PrinterPo printer);

    /**
     * @Date 2020/6/14 16:51
     * @Author 胖
     * 获取token
     **/
    PrinterPo queryToken();

    /**
     * @Date 2020/6/14 16:51
     * @Author 胖
     * 修改token
     **/
    void updateToken(PrinterPo printer);
}
