package com.mari.spring.app.v1;

import com.mari.spring.tracelog.TraceLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class HelloRepositoryV1 {

    private final TraceLog traceLog;

    public String getHello(String message){
        return "hello " + message;
    }
}
