package com.mari.spring.tracelog;

import lombok.Data;

@Data
public class StackLogV2 implements TraceLog{
    private StackStatusV2 stackStatusV2;
    private long startTime;
    private String message;

    public StackLogV2(StackStatusV2 stackStatus){
        this.stackStatusV2 = stackStatus;
    }

    public StackLogV2(){

    }

    public StackLogV2 begin(String message) {
        this.message = message;
        this.startTime = System.nanoTime();
        return this;
    }

    public void end(StackLogV2 stackLog) {
        long endTime = System.nanoTime();
        long interval = endTime - startTime;
        System.out.printf("[%s] : %s ,time=%d \n",stackStatusV2.getId(),message,interval);
    }


    public void exception(StackLogV2 stackLog, Exception e) {
        long endTime = System.nanoTime();
        long interval = endTime - startTime;
        System.out.printf("[%s] : %s ,time=%d \n",stackStatusV2.getId(),message,interval);
        System.out.printf("[%s] : exception=%s \n",stackStatusV2.getId(),e.getMessage());
    }
}
