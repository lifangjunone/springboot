package com.itheima.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect // AOP　类
public class TimeAspect {

    @Around("execution(* com.itheima.service.*.*(..))")

    public Object recordTime(ProceedingJoinPoint joinPoint) throws Throwable {

        // 1, 记录开始时间
        long begin = System.currentTimeMillis();

        // 2, 调用原始方法
        Object result = joinPoint.proceed();

        // ３, 记录结束时间
        long end = System.currentTimeMillis();

        log.info(joinPoint.getSignature() + "方法执行耗时：{}ms", end-begin);

        return result;
    }
}
