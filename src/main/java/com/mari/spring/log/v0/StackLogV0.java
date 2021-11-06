package com.mari.spring.log.v0;

import lombok.Data;

@Data
public class StackLogV0 {
    private StackStatusV0 stackStatusV0;
    private long startTime;
    private String message;

    public void start(){
        stackStatusV0 = new StackStatusV0();
        startTime = System.nanoTime();
    }

    public void end(){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : ", stackStatusV0.getId());
        System.out.println(end + " ns");

    }

    public void end(Exception e){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : ", stackStatusV0.getId());
        System.out.println(end + " ns");
        System.out.printf("[%s] : exception = %s", stackStatusV0.getId(),e.getClass().toString() );
    }

    public void end(String message){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : %s \n[%s] : elapsed time= %d ns\n", stackStatusV0.getId() , message , stackStatusV0.getId(), end );
    }

    public void end(String message, Exception e){
        long end = System.nanoTime() - startTime ;
        System.out.printf("[%s] : %s \n[%s] : elapsed time= %d ns\n", stackStatusV0.getId() , message , stackStatusV0.getId(), end );
        System.out.printf("[%s] : exception= %s", stackStatusV0.getId(),e.getMessage());
    }
}
