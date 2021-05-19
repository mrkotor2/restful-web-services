package com.training.spring_aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class MethodExecutionCalculationAspect {

    //execution(* PACKAGE.*.*(..))
    @Around("com.training.spring_aop.aspect.CommonJoinPointConfig.trackTime()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        joinPoint.proceed();
        long timeTaken = System.currentTimeMillis() - startTime;
        log.info("Time taken by {} is {}", joinPoint, timeTaken);
    }

}
