package com.bbd.aspect;

import com.bbd.annotation.TimeUsed;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.security.SignedObject;


/**
 * 监控方法耗时时间的切面类
 * @author Liuweibo
 * @version Id: TimeUsedAspect.java, v0.1 2017/9/29 Liuweibo Exp $$
 */
@Order
@Aspect
@Component
public class TimeUsedAspect {
    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 定义切入点（加了@TimeUsed注解的方法会被监控）
     * @param timeUsed
     */
    @Pointcut(value = "@annotation(timeUsed)", argNames = "timeUsed")
    public void timeUsedPointcut(TimeUsed timeUsed){}

    @Around(value = "com.bbd.aspect.TimeUsedAspect.timeUsedPointcut(timeUsed)")
    public Object around(ProceedingJoinPoint pjp, TimeUsed timeUsed) throws Throwable {
        Object obj;
        long start = System.currentTimeMillis();
        try {
            obj = pjp.proceed();
        } catch (Throwable throwable) {
            throw throwable;
        } finally {
            long end = System.currentTimeMillis();
            Signature sig = pjp.getSignature();
            if(!(sig instanceof MethodSignature)) {
                throw new IllegalArgumentException("该注解只能应用于方法上");
            }
            String methodName = sig.getDeclaringTypeName() + "." + sig.getName();
            long used = end - start;
            if(used >= timeUsed.threshold()) {
                logger.info(String.format("执行 %s 耗时: %d 毫秒", methodName, used));
            }
        }
        return obj;
    }

}























