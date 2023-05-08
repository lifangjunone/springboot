package com.itheima.aop;


import com.alibaba.fastjson.JSONObject;
import com.itheima.mapper.OperateLogMapper;
import com.itheima.pojo.OperateLog;
import com.itheima.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.Arrays;

/**
 *  定义切面类实现记录操作日志的功能
 */

@Slf4j //　日志支持
@Component // 将此切面类交给　IOC(控制反转) 容器进行管理　
@Aspect  // 设置此类为切面类
public class LogAspect {
    // 定义通知方法，使用环绕通知类型

    @Autowired
    private OperateLogMapper operateLogMapper;  // 注入记录日志的mapper

    @Autowired
    private HttpServletRequest request; // 通过注入的方式可以拿到本次请求的 request 对象

    @Around("@annotation(com.itheima.anno.Log)")
    public Object recordOperateLog(ProceedingJoinPoint joinPoint) throws Throwable {
        // 调用原始目标方法运行
        long begin = System.currentTimeMillis();
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        // 操作人ID，　当前登录员工的ID
        // 获取请求头中的 JWT　令牌，　解析令牌
        String jwt = request.getHeader("token");
        Claims claims = JwtUtils.parseJWT(jwt);  // 解析　JWT　内容，　解析结果是一个 map
        Integer operateUser = (Integer) claims.get("id");
        // 操作时间
        LocalDateTime operateTime = LocalDateTime.now();
        // 操作类名
        String className = joinPoint.getTarget().getClass().getName();
        //　操作方法名
        String methodName = joinPoint.getSignature().getName();
        // 方法参数
        Object[] args = joinPoint.getArgs();
        String methodParams = Arrays.toString(args);
        // 方法执行的返回值
        String returnValue = JSONObject.toJSONString(result);
        // 操作耗时
        Long costTime = end - begin;
        OperateLog operateLog = new OperateLog(null, operateUser, operateTime, className, methodName, methodParams, returnValue,costTime);
        operateLogMapper.insert(operateLog);
        log.info("记录操作日志到【OperateLog】表　{}", operateLog);
        return result;
    }
}
