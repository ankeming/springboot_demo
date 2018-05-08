package com.ankang.util;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

@Aspect
@Component
public class DemoAspect {
    @Autowired
    private RedisTemplate redisTemplate;
    @Pointcut("execution(public * com.ankang.DemoServive.*(..))")
    public void pointCut(){}
    @Around("pointCut()")
    public Object aroundAdivce(ProceedingJoinPoint pjd) throws Throwable {
        Object result = null;
//        MethodSignature ms = (MethodSignature)pjd.getSignature();
//        Method method = ms.getMethod();
//        Object[] args = pjd.getArgs();
//        for (Object arg : args) {
//            System.out.println("arg = " + arg);
//        }
//        result = pjd.proceed();
//        System.out.println(result);
//        return "gaila!";
        Object[] args = pjd.getArgs();
        Object key = args[0];
        result = redisTemplate.opsForValue().get(key);
        if(result == null){
            result = pjd.proceed();
            redisTemplate.opsForValue().set(key,result);
        }
        return result;
    }
}
