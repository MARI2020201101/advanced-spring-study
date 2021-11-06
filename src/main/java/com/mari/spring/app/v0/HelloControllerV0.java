package com.mari.spring.app.v0;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloControllerV0 {

    private final HelloServiceV0 helloServiceV0;

    @GetMapping("/hello")
    public String getHello(String message){
        return helloServiceV0.getHello(message);
    }
}
