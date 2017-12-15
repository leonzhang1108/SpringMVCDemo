package com.leon.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Author: jianliangzhang
 * Date: 2017/12/15
 * Time: 11:11
 */
@Component
@Aspect
public class TimeLoggingAspect {
    @Before("execution(* com.leon.serviceImpl.*.*(..))")
    public void logBefore() {
        System.out.println("@Before:" + new Date());
    }
}
