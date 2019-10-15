package com.khg.springaopudemy.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.khg.springaopudemy.data.*.*(..))")
    public void dataLayerExecution(){}

    @Pointcut("execution(* com.khg.springaopudemy.business.*.*(..))")
    public void businessLayerExecution(){}
}
