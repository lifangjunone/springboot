package com.itheima.anno;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)  // 该注解运行时生效
@Target(ElementType.METHOD) // 该注解作用在方法上
public @interface Log {
}
