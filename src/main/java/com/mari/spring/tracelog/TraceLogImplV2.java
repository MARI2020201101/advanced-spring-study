package com.mari.spring.tracelog;

import org.springframework.stereotype.Component;

@Component
public class TraceLogImplV2 implements TraceLog{

    private static StackStatusV2 stackIdHolder;

    private StackStatusV2 getStackIdHolder(){
        if(stackIdHolder==null){
            stackIdHolder = new StackStatusV2();
        }return stackIdHolder;
    }

    @Override
    public StackLogV2 begin(String message) {
        StackStatusV2 stackID = getStackIdHolder();
        StackLogV2 stackLog = new StackLogV2(stackID);
        stackLog.begin(message);
        return stackLog;
    }

    @Override
    public void end(StackLogV2 stackLog) {
        stackLog.end(stackLog);
        stackIdHolder=null;
    }

    @Override
    public void exception(StackLogV2 stackLog, Exception e) {
        stackLog.exception(stackLog,e);
        stackIdHolder=null;
    }
}
