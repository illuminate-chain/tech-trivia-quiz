package com.illuminatechain.techtriviaquiz.common.annotation;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Aspect
@Component
public class LogToDBAspect {

    @Around(value = "@annotation(com.illuminatechain.techtriviaquiz.common.annotation.LogToDB)")
    public Object logToDB(ProceedingJoinPoint joinPoint) throws Throwable {

        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod();
        LogToDB logToDB = method.getAnnotation(LogToDB.class);

        // 어노테이션의 db 속성 확인
        String db = logToDB.db();
        // todo: 어노테이션 입력에 따라 db 로그 입력 로직 구현
        System.out.println(db);

        Object proceed = joinPoint.proceed();

        return proceed;
    }

}
