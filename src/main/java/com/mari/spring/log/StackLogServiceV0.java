package com.mari.spring.log;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class StackLogServiceV0 {

    public StackLog begin(){
      StackLog stackLog = new StackLog();
      stackLog.start();
      return stackLog;
    }
    public void end(StackLog stackLog){
        log.info("");
        stackLog.end();

    }
    public void exception(StackLog stackLog, Exception e){
        log.info("");
        stackLog.end(e);
    }
}
