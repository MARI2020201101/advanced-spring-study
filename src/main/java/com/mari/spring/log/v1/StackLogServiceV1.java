package com.mari.spring.log.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StackLogServiceV1 {

    public StackLogV1 begin(String message){
        StackLogV1 stackLogV1= new StackLogV1();
        stackLogV1.start(message);
        return stackLogV1;
    }
    public void end(StackLogV1 stackLogV1){
        stackLogV1.end();
    }
    public void exception(StackLogV1 stackLogV1, Exception e){
        stackLogV1.end(e);
    }
}
