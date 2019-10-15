package com.khg.springaopudemy.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.khg.springaopudemy.data.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.khg.springaopudemy.business.*.*(..))")
    public void businessLayerExecution(){}

    @Pointcut("com.khg.springaopudemy.aspect.CommonJoinPointConfig.dataLayerExecution() && com.khg.springaopudemy.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public void allLayerExecution(){}

    @Pointcut("bean(*dao*)")
    public void beansContainingDao(){}

    @Pointcut("within(com.khg.springaopudemy.data.*)")
    public void dataLayerExecutionWithWithin(){}
}
