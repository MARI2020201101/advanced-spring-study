package com.mari.spring.aspect;

import com.mari.spring.app.v2.HelloService;
import com.mari.spring.app.v2.HelloServiceV2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.aop.support.AopUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class AspectTest {

    @Autowired
    private HelloService helloService;

    @Autowired
    ApplicationContext ctx;

    @Test
    public void testBean() throws Exception {
        HelloServiceV2 bean = ctx.getBean("helloServiceV2", HelloServiceV2.class);
        assertNotNull(bean);
        AspectConfiguration configuration = ctx.getBean(AspectConfiguration.class);
        assertNotNull(configuration);
    }

    @Test
    public void testSimpleLogAspectJ() {
        boolean result = AopUtils.isAopProxy(helloService);
        assertTrue(result);
        helloService.hello();
    }

}
