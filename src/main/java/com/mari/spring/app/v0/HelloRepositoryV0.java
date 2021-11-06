package com.mari.spring.app.v0;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepositoryV0 {

    public String getHello(String message){
        return "hello " + message;
    }
}
