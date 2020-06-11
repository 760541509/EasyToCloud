package com.yingtongquan.system.table.controller;

import com.yingtongquan.startcommon.base.ResultVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/system/table")
@Api(tags = "表格操作")
public class ImportExportTableController {

    @ApiOperation(value = "导出表格")
    @PostMapping("/exportTable")
    public ResultVo importTable(Integer shopId){
        return ResultVo.successResult();
    }
}
