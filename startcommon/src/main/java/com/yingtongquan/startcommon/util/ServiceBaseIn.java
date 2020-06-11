package com.yingtongquan.startcommon.util;

public interface ServiceBaseIn<ADD,DELETE,UPDATE,BYT,BYTCALL,BYTLIST,BYTLISTCALL> {

    Boolean addInfo(ADD info) throws Exception;

    Boolean deleteInfo(DELETE info) throws Exception;

    Boolean updateInfo(UPDATE info) throws Exception;

    BYTCALL getByInfo(BYT info) throws Exception;

    BYTLISTCALL getListByInfo(BYTLIST info) throws Exception;


}
