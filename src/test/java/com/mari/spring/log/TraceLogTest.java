package com.mari.spring.log;

import com.mari.spring.tracelog.StackLogV2;
import com.mari.spring.tracelog.TraceLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class TraceLogTest {

    @Autowired
    TraceLog traceLog;

    @Test
    public void traceLogV2Test() throws Exception {
        StackLogV2 begin1 = traceLog.begin("start!");
        StackLogV2 begin2 = traceLog.begin("start222222");
        traceLog.end(begin2);
        traceLog.end(begin1);
    }
    @Test
    public void traceLogV2Test2() throws Exception {
        StackLogV2 begin1 = traceLog.begin("start!");
        StackLogV2 begin2 = traceLog.begin("start222222");
        traceLog.end(begin2);
        traceLog.end(begin1);

        StackLogV2 begin3 = traceLog.begin("start!");
        StackLogV2 begin4 = traceLog.begin("start222222");
        traceLog.end(begin4);
        traceLog.end(begin3);

    }
}
