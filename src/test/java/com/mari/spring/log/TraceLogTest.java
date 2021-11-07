package com.mari.spring.log;

import com.mari.spring.app.v1.HelloServiceV1;
import com.mari.spring.tracelog.StackLogV2;
import com.mari.spring.tracelog.TraceLog;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootTest
public class TraceLogTest {

    @Autowired
    TraceLog traceLog;

    @Autowired
    HelloServiceV1 helloService;


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

    @Test
    public void concurruncyTest() throws Exception {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        AtomicInteger idx = new AtomicInteger();
        executor.initialize();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
            executor.execute(()->{
                for (int i = 0; i < 10; i++) {

                String hello = helloService.getHello("spring" + idx.addAndGet(1));
                System.out.println(hello);}
            });

        executor.shutdown();

        Thread.currentThread().join(3000);
    }
    @Test
    public void concurruncyTest2() throws Exception {

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        AtomicInteger idx = new AtomicInteger();
        executor.initialize();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);
        //각자의 스레드가 10번 돈다
        for (int i = 0; i < 10; i++) {
        executor.execute(()->{
                String hello = helloService.getHello("spring" + idx.addAndGet(1));
                System.out.println(hello);});
        }
        executor.shutdown();

        Thread.currentThread().join(3000);
    }
}
