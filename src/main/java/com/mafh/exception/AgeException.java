package com.mafh.exception;

import com.mafh.enums.MessageEnum;

/**
 * Created by mafh on 2017/6/27 0027.15:10
 */
public class AgeException extends RuntimeException {
    private Integer code;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public AgeException(String message, Integer code) {
        super(message);
        this.code = code;
    }

    public AgeException(MessageEnum messageEnum) {
        super(messageEnum.getMsg());
        this.code = messageEnum.getCode();
    }
}
