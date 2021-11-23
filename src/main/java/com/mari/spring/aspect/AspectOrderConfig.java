package com.mari.spring.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;

@Slf4j
@Aspect
@Component
public class AspectOrderConfig {

    @Order(2)
    @Around("execution(* com.mari.spring.app..*.*())")
    public Object simpleLog2(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("***************************");
        Object proceed = joinPoint.proceed();
        Object target = joinPoint.getTarget();
        String simpleName = target.getClass().getSimpleName();
        log.info("simpleName {}" , simpleName);
        Annotation[] annotations = target.getClass().getAnnotations(); //타겟을 조작해서 메타정보를 끍어올수있다.. 후후
        for (Annotation annotation : annotations) {
            log.info("annotation : {}", annotation);
        }
        log.info("****************************");
        return proceed;
    }

    @Order(1)
    @Around("execution(* com.mari.spring.app..*.*())")
    public Object simpleLog1(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("===============================");
        Object proceed = joinPoint.proceed();
        log.info("===============================");
        return proceed;
    }



}
