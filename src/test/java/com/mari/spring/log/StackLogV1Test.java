package com.mari.spring.log;

import com.mari.spring.app.v0.HelloServiceV0;
import com.mari.spring.log.v1.StackLogServiceV1;
import com.mari.spring.log.v1.StackLogV1;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class StackLogV1Test {

    @Autowired
    StackLogServiceV1 stackLogServiceV1;

    @Autowired
    HelloServiceV0 helloServiceV0;

    @Test
    public void stackLogTest() throws Exception {

        StackLogV1 begin = stackLogServiceV1.begin("helloServiceV0.getHello");
        String hello = helloServiceV0.getHello("spring");
        System.out.println(hello);
        stackLogServiceV1.end(begin);

    }

    @Test
    public void stackLogExceptionTest() throws Exception {
        StackLogV1 begin = null;

        try{
            begin= stackLogServiceV1.begin("helloServiceV0.getHello");
            String hello = helloServiceV0.getHello("spring");
            System.out.println(hello);
            throw  new RuntimeException("rrrrrrr");
        }catch (Exception e){
            stackLogServiceV1.exception(begin ,e);
        }
    }

}
