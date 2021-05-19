package com.training.spring_aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect // point + advice
@Configuration
public class UserAccessAspect {

    //execution(* PACKAGE.*.*(..))
    @Before("com.training.spring_aop.aspect.CommonJoinPointConfig.dataLayerExecution()") //pointcut
    public void before(JoinPoint joinPoint){ // specific exe instance
        // advice
        log.info("Check for user access "); //TODO real check if it is needed
        log.info("Allowed access for {}", joinPoint);
    }
}
