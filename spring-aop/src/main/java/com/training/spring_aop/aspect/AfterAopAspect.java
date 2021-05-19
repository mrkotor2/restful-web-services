package com.training.spring_aop.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Aspect
@Configuration
public class AfterAopAspect {

    //execution(* PACKAGE.*.*(..))
    @AfterReturning(value = "com.training.spring_aop.aspect.CommonJoinPointConfig.businessLayerExecution()",
    returning = "result") //pointcut
    public void afterReturning(JoinPoint joinPoint, Object result){
        log.info("{} returned with value {}", joinPoint, result);
    }

    @AfterThrowing(value = "com.training.spring_aop.aspect.CommonJoinPointConfig.dataLayerExecution()",
            throwing = "exception") //pointcut
    public void afterReturning(JoinPoint joinPoint, Exception exception){
        log.info("{} throw exception {}", joinPoint, exception);
    }

    //common After
    @After("execution(* com.training.spring_aop.aspect.CommonJoinPointConfig.businessLayerExecution())")
    public void after(JoinPoint joinPoint){
        log.info("after execution of {}", joinPoint);
    }
}
