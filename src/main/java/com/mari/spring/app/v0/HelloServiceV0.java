package com.mari.spring.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
public class HelloServiceV0 {

    private final HelloRepositoryV0 helloRepositoryV0;

    public String getHello(String message){
        if(message.equals("ex")){
            throw new RuntimeException("μμΈλ°μ!!!");
        }
        return helloRepositoryV0.getHello(message);
    }
}
