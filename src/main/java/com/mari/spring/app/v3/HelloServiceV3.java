package com.mari.spring.app.v3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloServiceV3 {

    public void hello(){
        log.info("뭔가 복잡한 비지니스 로직...");
    }
}
