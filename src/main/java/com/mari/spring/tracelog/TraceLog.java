package com.mari.spring.tracelog;

import com.mari.spring.log.v1.StackLogV1;

public interface TraceLog {

    StackLogV2 begin(String message);
    void end(StackLogV2 stackLog);
    void exception( StackLogV2 stackLog, Exception e);
}
