package com.mari.spring.log;

import lombok.Data;

import java.util.UUID;

@Data
public class StackStatus {

    private String id;
    private Integer indent;

    public StackStatus(){
        id=UUID.randomUUID().toString().substring(0,8);
        indent=0;
    }

}
