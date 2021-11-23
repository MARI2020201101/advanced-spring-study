package com.mari.spring.app.v3;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.ProxyMethodInvocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

@Slf4j
@RequiredArgsConstructor
public class MyMethodInterceptor implements MethodInterceptor {
    private final HelloServiceV3 target;

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        log.info("---------------------------------------------");
        Object invoke = methodProxy.invoke(target, null);
        log.info("---------------------------------------------");
        return invoke;
    }
}
