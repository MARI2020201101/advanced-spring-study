package com.mari.spring.log.v1;

import lombok.Data;

import java.util.UUID;

@Data
public class StackStatusV1 {

    private String id;

    public StackStatusV1(){
        id=UUID.randomUUID().toString().substring(0,8);
    }

}
