package com.mari.spring.log.v1;

import lombok.Data;

@Data
public class StackLogV1 {
    private StackStatusV1 stackStatusV1;
    private long startTime;
    private String message;

    public void start(String message){
        this.message = message;
        stackStatusV1 = new StackStatusV1();
        startTime = System.nanoTime();
    }

    public void end(){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] %s time=%d ns", stackStatusV1.getId(), this.message, end);

    }

    public void end(Exception e){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] %s time=%d ns\n", stackStatusV1.getId(), this.message, end);
        System.out.printf("[%s] %s exception = %s", stackStatusV1.getId(),this.message, e.getClass().toString() );
    }

}
