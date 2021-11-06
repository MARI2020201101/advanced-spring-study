package com.mari.spring.log.v0;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StackLogServiceV0 {

    public StackLogV0 begin(){
      StackLogV0 stackLogV0 = new StackLogV0();
      stackLogV0.start();
      return stackLogV0;
    }
    public void end(String message, StackLogV0 stackLogV0){
        stackLogV0.end(message);
    }
    public void exception(String message, StackLogV0 stackLogV0, Exception e){
        stackLogV0.end(message, e);
    }
}
