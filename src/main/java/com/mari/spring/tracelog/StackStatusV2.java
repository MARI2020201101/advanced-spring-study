package com.mari.spring.tracelog;

import lombok.Data;

import java.util.UUID;

@Data
public class StackStatusV2 {

    private String id;

    public StackStatusV2(){
        id=UUID.randomUUID().toString().substring(0,8);
    }

}
