package com.yingtongquan.system.table.service;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.formula.functions.T;

import javax.servlet.http.HttpServletResponse;
import java.util.LinkedHashMap;
import java.util.List;

public interface ImportExportTableService {

    /**
     * @Date 2020/5/21 11:14
     * @Author 胖
     * 导出表格
     **/
    void exportTable(String excelName, List<T> list, LinkedHashMap<String, String> fieldMap, HttpServletResponse response);

    /**
     * @Date 2020/5/21 11:14
     * @Author 胖
     * 导入表格
     **/
    void importTable(HSSFSheet sheet, List<T> list,LinkedHashMap<String, String> fieldMap, HSSFCellStyle style);

}
