package com.khg.springaopudemy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class AfterAOPAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @AfterReturning(
            value = "com.khg.springaopudemy.aspect.CommonJoinPointConfig.dataLayerExecution()",
            returning = "result")
    public void after(JoinPoint joinPoint, Object result) {
        logger.info("{} returned value with {}", joinPoint, result);
    }

    @AfterThrowing(value = "com.khg.springaopudemy.aspect.CommonJoinPointConfig.dataLayerExecution()", throwing = "exception")
    public void afterThrowing(JoinPoint joinPoint, Object exception) {
        logger.info("{} returned value with {}", joinPoint, exception);
    }

    @After(value = "com.khg.springaopudemy.aspect.CommonJoinPointConfig.dataLayerExecution()")
    public void afterThrowing(JoinPoint joinPoint) {
        logger.info("After execution of {}", joinPoint);
    }
}
