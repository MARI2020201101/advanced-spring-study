package com.mari.spring.log;

import com.mari.spring.app.HelloController;
import com.mari.spring.app.HelloService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StackLogTest {

    @Autowired
    HelloController helloController;

    @Autowired
    HelloService helloService;

    @Autowired
    StackLogServiceV0 stackLogServiceV0;

    @Test
    public void testStackLog() throws Exception {
        StackLog stackLog = new StackLog();
    }

    @Test
    public void controllerTest() throws Exception {
        helloController.getHello("spring");
    }

    @Test
    public void serviceTest() throws Exception {
        long start = System.nanoTime();

        String hello = helloService.getHello("spring");
        System.out.println(hello);
        long end = System.nanoTime();

        long interval=end - start;
        System.out.println("interval :" +interval );
    }

    @Test
    public void logTest(){
        StackLog stackLog = new StackLog();
        stackLog.start();
        String hello = helloService.getHello("spring");
        System.out.println(hello);
        stackLog.end();
    }

    @Test
    public void exLogTest() throws Exception {
        StackLog stackLog = new StackLog();
        stackLog.start();
        try{
            String hello = helloService.getHello("spring");
            System.out.println(hello);
            throw new Exception("ddddd!!");
        }catch (Exception e){
            stackLog.end(e);
        }
    }

    @Test
    public void stackLogServiceTest() throws Exception {

    }




}
