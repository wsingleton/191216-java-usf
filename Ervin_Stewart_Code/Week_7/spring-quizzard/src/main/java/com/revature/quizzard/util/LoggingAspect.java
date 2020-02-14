package com.revature.quizzard.util;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.Arrays;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Aspect
@Component
public class LoggingAspect {
    private final Logger LOG = LogManager.getLogger(this.getClass());

    @Pointcut("within(com.revature..*)")
    public void logAll(){}

    @Before("logAll()")
    public void logMethodStart(JoinPoint jp){
        String methodSig = jp.getTarget().getClass().toString()+"."+jp.getSignature().getName();
        LOG.info("{} invoked at {}", methodSig, LocalTime.now());
        LOG.info("Input arguments: {}", Arrays.toString(jp.getArgs()));
    }
}
