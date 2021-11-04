package com.mari.spring.log;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class StackLog {
    private StackStatus stackStatus;
    private String logMsg;

    public void log(){
        System.out.printf("[%s] : ",stackStatus.getId());
        System.out.print(logMsg);
    }


}
