package com.mari.spring;

import com.mari.spring.app.v1.HelloServiceV1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.atomic.AtomicInteger;

@SpringBootApplication
//@EnableAspectJAutoProxy //boot는 자동설정..
public class AdvancedSpringApplication {
	@Autowired
	HelloServiceV1 helloService;

	@Bean
	public ApplicationRunner applicationRunner() {
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
				AtomicInteger idx = new AtomicInteger();
				executor.initialize();
				executor.setCorePoolSize(10);
				executor.setMaxPoolSize(10);

				for (int i = 0; i < 10; i++) {
					executor.execute(()->{
						String hello = helloService.getHello("spring" + idx.addAndGet(1));
						System.out.println(hello);});
				}
				executor.shutdown();

			}
		};
	}
	public static void main(String[] args) throws Exception {
		SpringApplication.run(AdvancedSpringApplication.class, args);
	}

}
