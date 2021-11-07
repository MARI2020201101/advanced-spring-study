package com.mari.spring.log;

import com.mari.spring.app.v0.HelloServiceV0;
import com.mari.spring.app.v1.HelloRepositoryV1;
import com.mari.spring.app.v1.HelloServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadTest {

    public static void main(String[] args) {

        //일반 자바 메인에서 돌리면 실행안되는 오류(?) 가 없다.
        //아마 JUnit테스트 프레임워크의 생명주기와 관련한 문제인듯

        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        AtomicInteger idx = new AtomicInteger();
        executor.initialize();
        executor.setCorePoolSize(10);
        executor.setMaxPoolSize(10);

        for (int i = 0; i < 10; i++) {
            executor.execute(()->{
                System.out.println("spring" + idx.addAndGet(1));
                });
        }
        executor.shutdown();
    }

}
