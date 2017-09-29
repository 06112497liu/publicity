package com.bbd.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 监控方法耗时时间的消耗注解
 * @author Liuweibo
 * @version Id: TimeUsed.java, v0.1 2017/9/29 Liuweibo Exp $$
 */
@Target(value = ElementType.METHOD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface TimeUsed {
    long threshold() default 0L;
}
