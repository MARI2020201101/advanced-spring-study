package com.mari.spring.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceV0 {

    private final HelloRepositoryV0 helloRepositoryV0;

    public String getHello(String message){
        if(message.equals("ex")){
            throw new RuntimeException("예외발생!!!");
        }
        return helloRepositoryV0.getHello(message);
    }
}
