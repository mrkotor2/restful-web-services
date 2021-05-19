package com.training.spring_aop.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class CommonJoinPointConfig {
    @Pointcut("execution(* com.training.spring_aop.data.*.*(..))")
    public void dataLayerExecution(){ }

    @Pointcut("execution(* com.training.spring_aop.business.*.*(..))")
    public  void businessLayerExecution(){}

    @Pointcut("com.training.spring_aop.aspect.CommonJoinPointConfig.dataLayerExecution() && com.training.spring_aop.aspect.CommonJoinPointConfig.businessLayerExecution()")
    public  void allLayerExecution(){}

    @Pointcut("bean(*dao*)")
    public  void beanStartingWithDao(){}

    @Pointcut("within(com.training.spring_aop.data..*)")
    public void dataLayerExecutionWithWithin(){ }

    @Pointcut("@annotation(com.training.spring_aop.data.TrackTime)")
    public void trackTime(){}

}
