package com.xtt.log.web.log.aspect;

import com.alibaba.fastjson.JSON;
import com.xtt.lib.entity.OperationLog;
import com.xtt.lib.util.NetworkUtil;
import com.xtt.web.log.LogAnnotation;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

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
        long time = System.currentTimeMillis();
        try {
            res = joinPoint.proceed();
            time = System.currentTimeMillis() - time;
            return res;
        } finally {
            addOperationLog(joinPoint, res, time);
        }
    }

    private void addOperationLog(JoinPoint joinPoint, Object res, long time) throws Exception {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        HttpServletRequest request = ((ServletRequestAttributes) Objects.requireNonNull(RequestContextHolder.getRequestAttributes())).getRequest();
        OperationLog operationLog = new OperationLog();
        operationLog.setRunTime(time);
        operationLog.setReturnValue(JSON.toJSONString(res));
        operationLog.setCreateTime(System.currentTimeMillis());
        operationLog.setMethod(signature.getDeclaringTypeName() + "." + signature.getName());
        operationLog.setIp(NetworkUtil.getIpAddress(request));
        LogAnnotation annotation = signature.getMethod().getAnnotation(LogAnnotation.class);
        if(annotation != null){
            log.info("注解LogAnnotation: " + JSON.toJSONString(annotation));
            operationLog.setDescribe(annotation.detail().getValue());
            operationLog.setOperationType(annotation.operationType().getValue());
            operationLog.setOperationUnit(annotation.operationUnit().getCode());
            log.info("operationLog的getMethod方法测试： " + operationLog.getMethod());
        }
    }
}
