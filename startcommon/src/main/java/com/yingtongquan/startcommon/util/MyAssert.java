package com.yingtongquan.startcommon.util;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;

public class MyAssert extends Assert {

    public static Object  notEmpty(Object text, String errorMsgTemplate, Object... params) throws IllegalArgumentException {
        if (text==null||StrUtil.isEmpty(text.toString())) {
            throw new IllegalArgumentException(StrUtil.format(errorMsgTemplate, params));
        } else {
            return text;
        }
    }

}
