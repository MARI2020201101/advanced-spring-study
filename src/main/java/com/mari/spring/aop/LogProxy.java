package com.mari.spring.aop;

import com.mari.spring.log.v0.StackLogV0;
import com.mari.spring.log.v0.StackLogServiceV0;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

@Component
public class LogProxy implements InvocationHandler {


    private Object target;
    @Autowired
    private StackLogServiceV0 stackLogServiceV0;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        StackLogV0 begin = stackLogServiceV0.begin();
        Object invoke = method.invoke(target, args);
        stackLogServiceV0.end(target.getClass().toString() , begin);

        return null;
    }
}
