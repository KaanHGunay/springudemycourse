package com.khg.springaopudemy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class UserAccessAspect {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Before("execution(* com.khg.springaopudemy.business.*.*(..))")  // Classta herhangi bir dönüş tipine sahip tüm classları yakala
    public void before(JoinPoint joinPoint) {
        logger.info("Intercepted method called. -> {}", joinPoint);
    }
}
