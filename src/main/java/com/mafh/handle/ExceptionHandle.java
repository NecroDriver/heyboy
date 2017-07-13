package com.mafh.handle;

import com.mafh.domain.Message;
import com.mafh.enums.MessageEnum;
import com.mafh.exception.AgeException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by mafh on 2017/6/27 0027.14:57
 */
/*
@RestControllerAdvice = @ControllerAdvice +@ResponseBody
 */
@ControllerAdvice
public class ExceptionHandle {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Message handle(Exception e){
        Message msg = new Message();
        if(e instanceof AgeException){
            AgeException ageException = (AgeException)e;
            msg.setErrcode(ageException.getCode());
            msg.setErrmsg(ageException.getMessage());
            return msg;
        }else{
            logger.info("【系统异常】={}",e);
            return new Message(MessageEnum.UNKONW_ERROR);
        }
    }
}
