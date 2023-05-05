package com.itheima.aop;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class MyAspect {


    @Pointcut("execution(* com.itheima.service.*.*(..))")
    private void pt() {}


    @Pointcut("@annotation(com.itheima.aop.MyLog)")
    @Before("pt()")
    public void before() {
        log.info("before ...");
    }

    @Around("pt()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        log.info("around ... before");
        Object result = joinPoint.proceed();
        log.info("around ... after");
        return result;
    }

    @After("pt()")
    public void after() {
        log.info("after ...");
    }

    @AfterReturning("pt()")
    public void afterReturning() {
        log.info("afterReturning ...");
    }

    @AfterThrowing("pt()")
    public void afterThrowing() {
        log.info("afterThrowing ...");
    }
}
