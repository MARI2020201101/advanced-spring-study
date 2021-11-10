package com.mari.spring.templateMethod;

import org.junit.jupiter.api.Test;

public class TemplateMethodTest {

    @Test
    public void sampleTemplateMethodTest(){
        SampleTemplateMethod stm = new SampleTemplateMethod() {
            @Override
            void businessLogicMethod() {
                System.out.println("complex business logic...");
            }
        };

        stm.doSomething();
    }
    static abstract class SampleTemplateMethod{
        public final void doSomething(){
            System.out.println("----------------start log-------------");
            businessLogicMethod();
            System.out.println("-----------------end log--------------");
        }
        abstract void businessLogicMethod();
    }
}

