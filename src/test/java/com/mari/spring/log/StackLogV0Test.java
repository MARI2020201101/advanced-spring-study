package com.mari.spring.log;

import com.mari.spring.aop.LogProxy;
import com.mari.spring.app.v0.HelloControllerV0;
import com.mari.spring.app.v0.HelloServiceV0;
import com.mari.spring.log.v0.StackLogV0;
import com.mari.spring.log.v0.StackLogServiceV0;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StackLogV0Test {

    @Autowired
    HelloControllerV0 helloControllerV0;

    @Autowired
    HelloServiceV0 helloServiceV0;

    @Autowired
    StackLogServiceV0 stackLogServiceV0;

    @Autowired
    LogProxy logProxy;

    @Test
    public void testStackLog() throws Exception {
        StackLogV0 stackLogV0 = new StackLogV0();
    }

    @Test
    public void controllerTest() throws Exception {
        helloControllerV0.getHello("spring");
    }

    @Test
    public void serviceTest() throws Exception {
        long start = System.nanoTime();

        String hello = helloServiceV0.getHello("spring");
        System.out.println(hello);
        long end = System.nanoTime();

        long interval=end - start;
        System.out.println("interval :" +interval );
    }

    @Test
    public void logTest(){
        StackLogV0 stackLogV0 = new StackLogV0();
        stackLogV0.start();
        String hello = helloServiceV0.getHello("spring");
        System.out.println(hello);
        stackLogV0.end();
    }

    @Test
    public void exLogTest() throws Exception {
        StackLogV0 stackLogV0 = new StackLogV0();
        stackLogV0.start();
        try{
            String hello = helloServiceV0.getHello("spring");
            System.out.println(hello);
            throw new Exception("ddddd!!");
        }catch (Exception e){
            stackLogV0.end(e);
        }
    }

    @Test
    public void stackLogServiceTest() throws Exception {
        StackLogV0 begin = stackLogServiceV0.begin();
        helloServiceV0.getHello("spring");
        stackLogServiceV0.end("message",begin);

    }

    @Test
    public void stackLogServiceExceptionTest() throws Exception {
        StackLogV0 begin = stackLogServiceV0.begin();
        try{
            helloServiceV0.getHello("spring");
            throw new RuntimeException("rrrrrr");
        }catch(Exception e){
            stackLogServiceV0.exception("messege", begin,e);
        }
    }
}
