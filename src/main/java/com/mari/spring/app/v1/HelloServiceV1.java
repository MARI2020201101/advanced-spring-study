package com.mari.spring.app.v1;

import com.mari.spring.tracelog.StackLogV2;
import com.mari.spring.tracelog.TraceLog;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HelloServiceV1 {

    private final HelloRepositoryV1 helloRepositoryV1;
    private final TraceLog traceLog;

    public String getHello(String message) {
        StackLogV2 begin = null;
        try {
            begin = traceLog.begin(this.getClass().toString());
            if (message.equals("ex")) {
                throw new RuntimeException("μμΈλ°μ!!!");
            }
        } catch (Exception e) {
            traceLog.exception(begin, e);
        }
        traceLog.end(begin);
        return helloRepositoryV1.getHello(message);
    }
    }
