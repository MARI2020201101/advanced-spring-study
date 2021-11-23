package com.mari.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
//@Component
@Slf4j
public class AspectConfiguration {

    @Around("execution(* com.mari.spring.app..*.*())")
    public Object simpleLog(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===============================");
        Object proceed = joinPoint.proceed();
        log.info("===============================");
        return proceed;
    }

    @Around("execution(* hello())")
    public Object simpleLog2(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===============================");
        Object proceed = joinPoint.proceed();
        log.info("===============================");
        return proceed;
    }

    @Before("execution(* hello())")
    public void someBeforeAdviceMethod(JoinPoint joinPoint){
        log.info("===============================");
        String signature = joinPoint.getSignature().getName();
        log.info("signature name : " + signature);
    }

}
