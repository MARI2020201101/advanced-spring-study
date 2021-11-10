package com.mari.spring.tracelog;

import org.springframework.stereotype.Component;

@Component
public class TraceLogImplV3 implements TraceLog{

    private static ThreadLocal<StackStatusV2> stackIdHolder;

    private StackStatusV2 getStackIdHolder(){
        if(stackIdHolder==null){
            stackIdHolder.set(new StackStatusV2());
        }return stackIdHolder.get();
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
        stackIdHolder.remove();
    }

    @Override
    public void exception(StackLogV2 stackLog, Exception e) {
        stackLog.exception(stackLog,e);
        stackIdHolder.remove();
    }
}
