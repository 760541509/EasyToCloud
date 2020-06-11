package com.yingtongquan.startcommon.util;


import com.yingtongquan.startcommon.base.ResultVo;

public class ServiceUtil {

    public ResultVo execute(ServiceIn serviceIn) {

        Object returnInfo = null;

        try {
            returnInfo = serviceIn.dataOp();

            if (returnInfo instanceof Boolean && !((Boolean) returnInfo)) {
                return ResultVo.failResult("操作失败了.");
            } else if (returnInfo == null) {
                return ResultVo.failResult("未查询到数据.");
            }
            return ResultVo.successResult(returnInfo);
        } catch (Exception e) {
//            e.printStackTrace();
            if (e instanceof IllegalArgumentException) {
                return ResultVo.errorResult(e.getMessage());
            }
            return ResultVo.errorResult("操作出错了.");
        }

    }

}
