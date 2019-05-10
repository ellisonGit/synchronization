package com.gdeastriver.datasync.enums;

/**
 * Description:
 * User: by yangyong
 * Date: 2018-04-03
 * Time: 11:43
 * Modified:
 */
public enum InfoEnum {

    //Enum采用大写加下划线组合
    SUCCESS("000001","SUCCESS"),
    FAILUE("-1","FAILUE");


    private String code;
    private String msg;

    InfoEnum(String code, String msg) {
        this.code=code;
        this.msg=msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
