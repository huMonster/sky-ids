package com.xtt.ids.web.log.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Description LogAspect
 * @Author Monster
 * @Date 2021/3/16 17:49
 * @Version 1.0
 */
@Slf4j(topic = "monitor")
@Aspect
@Component
public class LogAspect {

    /**
     * 此处的切点是注解的方式，也可以用包名的方式达到相同的效果
     * '@Pointcut("execution(* com.java.springboot.service.impl.*.*(..))")'
     */
    @Pointcut("@annotation(com.xtt.web.log.LogAnnotation)")
    public void operationLog(){}

    /**
     * 环绕增强，可采用线程池异步输出日志，尽量不影响业务响应速度
     */
    @Around("operationLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable{
        Object res = null;
        return res;
    }

}
