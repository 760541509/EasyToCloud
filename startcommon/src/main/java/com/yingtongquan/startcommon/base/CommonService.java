package com.yingtongquan.startcommon.base;

import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class CommonService {

    @Autowired
    private static CommonService commonService;

    @PostConstruct
    public void init() {
        commonService = this;
    }

    public static CommonService instance() {
        return commonService;
    }

}
