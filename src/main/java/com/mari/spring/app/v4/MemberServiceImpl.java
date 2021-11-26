package com.mari.spring.app.v4;

import com.mari.spring.app.v4.annotation.MyClassAnnotation;
import com.mari.spring.app.v4.annotation.MyMethodAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@MyClassAnnotation
@Slf4j
public class MemberServiceImpl implements MemberService{
    @Override
    @MyMethodAnnotation("super super cute")
    public String hello(String message) {
        return "hello " + message;
    }

    @MyMethodAnnotation("super super cute")
    public void hello2(String message){
        log.info("hello {} ", message);
    }
}
