package com.mafh.enums;

/**
 * Created by mafh on 2017/6/27 0027.15:36
 */
public enum MessageEnum {
    UNKONW_ERROR(-1,"未知错误"),
    SUCCESS(0,"成功"),
    PRIMARY_SCHOOL(23331,"你还在上小学吧"),
    MIDDLE_SHCOOL(23332,"你可能在上初中");

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    MessageEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
