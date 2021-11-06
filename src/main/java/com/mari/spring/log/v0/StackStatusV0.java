package com.mari.spring.log.v0;

import lombok.Data;

import java.util.UUID;

@Data
public class StackStatusV0 {

    private String id;

    public StackStatusV0(){
        id=UUID.randomUUID().toString().substring(0,8);
    }

}
