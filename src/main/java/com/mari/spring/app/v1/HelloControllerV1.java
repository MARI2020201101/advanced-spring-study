package com.mari.spring.app.v1;

import com.mari.spring.tracelog.StackLogV2;
import com.mari.spring.tracelog.TraceLog;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class HelloControllerV1 {

    private final HelloServiceV1 helloServiceV0;
    private final TraceLog traceLog;

    @GetMapping("/hello")
    public String getHello(String message){
        StackLogV2 begin = traceLog.begin(this.getClass().toString());
        String hello = helloServiceV0.getHello(message);
        traceLog.end(begin);
        return hello;
    }
}
