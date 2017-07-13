package com.mafh.domain;

import com.mafh.enums.MessageEnum;

/**
 * Created by mafh on 2017/6/27 0027.14:34
 */
public class Message<T> {
    private Integer errcode;
    private String errmsg;
    private T data;

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "errcode=" + errcode +
                ", errmsg='" + errmsg + '\'' +
                ", data=" + data +
                '}';
    }

    public Message(MessageEnum messageEnum) {
        this.errcode = messageEnum.getCode();
        this.errmsg = messageEnum.getMsg();
    }

    public Message() {
    }
}
