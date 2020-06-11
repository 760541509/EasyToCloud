package com.yingtongquan.startcommon.exception;

import com.yingtongquan.startcommon.base.ResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


@ControllerAdvice
@ResponseBody
public class AssertException extends Throwable {

    private static Logger logger = LoggerFactory.getLogger(AssertException.class);

    @ResponseBody
    @ExceptionHandler(value = IllegalArgumentException.class)
    public ResultVo illegalArgumentErrorHandler(IllegalArgumentException ex) {
        String message = ex.getLocalizedMessage();
        System.out.println(message);
        if(ex.getCause() != null){
            message = ex.getCause().getMessage();
        }
        return ResultVo.failResult(message);
    }
}