package com.mari.spring.app;

import org.springframework.stereotype.Repository;

@Repository
public class HelloRepository {

    public String getHello(String message){
        return "hello " + message;
    }
}
