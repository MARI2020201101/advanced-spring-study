package com.mari.spring.log;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Data
public class StackLog {
    private StackStatus stackStatus;
    private long startTime;
    private String message;

    public void start(){
        stackStatus = new StackStatus();
        startTime = System.nanoTime();
    }

    public void end(){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : ",stackStatus.getId());
        System.out.println(end + " ns");

    }

    public void end(Exception e){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : ",stackStatus.getId());
        System.out.println(end + " ns");
        System.out.printf("[%s] : exception = %s",stackStatus.getId(),e.getClass().toString() );
    }

    public void end(String message){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : %s",stackStatus.getId() , message);
        System.out.println(end + " ns");

    }

    public void end(String message, Exception e){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : %s",stackStatus.getId() , message);
        System.out.println(end + " ns");
        System.out.printf("[%s] : exception = %s",stackStatus.getId(),e.getClass().toString() );
    }
}
