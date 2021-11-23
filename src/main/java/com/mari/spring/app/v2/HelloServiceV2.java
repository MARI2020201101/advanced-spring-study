package com.mari.spring.app.v2;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceV2 implements HelloService{

    public void hello(){
        System.out.println(" hello my name is hello service");
        System.out.println(" 뭔가 복잡한 비지니스 로직...");
    }
}
