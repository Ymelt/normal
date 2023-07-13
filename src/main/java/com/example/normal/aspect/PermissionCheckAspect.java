package com.example.normal.aspect;


import com.alibaba.fastjson2.JSONObject;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PermissionCheckAspect {

    @Pointcut("@annotation(com.example.normal.annotaion.PrePermission)")
    private void permissionCheck(){

    }

    @Around("permissionCheck()")
    public Object permissionCheckFirst(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] args = joinPoint.getArgs();
//        for (Object arg : args) {
//            JSONObject arg1 = (JSONObject) arg;
//            System.out.println(arg1);
//        }
//        return args;
        Object target = joinPoint.getTarget();
        
        System.out.println("zheli shi huanrao zhixing");
        return joinPoint.proceed();
    }


}
