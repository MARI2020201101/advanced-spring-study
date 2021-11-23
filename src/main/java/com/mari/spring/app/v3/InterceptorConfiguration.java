package com.mari.spring.app.v3;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.proxy.Enhancer;

@SpringBootApplication
public class InterceptorConfiguration {

    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceV3.class);
        enhancer.setCallback(new MyMethodInterceptor(new HelloServiceV3()));
        Object helloService = enhancer.create();
        ((HelloServiceV3)helloService).hello();
    }

}
