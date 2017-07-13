package com.mafh.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mafh on 2017/6/27 0027.13:33
 */
@Aspect
@Component
public class HttpAspect {

    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Pointcut("execution(public * com.mafh.controller.GirlController.*(..))")
    public void log(){}

    @Before("log()")
    public void doBefore(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        /*
        记录url
         */
        logger.info("url={}",request.getRequestURL());
        /*
        记录method
         */
        logger.info("method={}",request.getMethod());
        /*
        记录ip
         */
        logger.info("ip={}",request.getRemoteAddr());
        /*
        记录方法
         */
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
         /*
        记录参数
         */
        logger.info("args={}",joinPoint.getArgs());
        System.out.println("before run");
        logger.info("before run");
    }

    @After("log()")
    public void doAfter(){
        System.out.println("after run");
        logger.info("after run");
    }
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object);
    }
}
