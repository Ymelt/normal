//package com.example.normal.aspect;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.*;
//import org.springframework.stereotype.Component;
//
//@Aspect
//@Component
//public class AopAdvice {
//
//    @Pointcut("execution(* com.example.normal.controller.*.*(..))")
//    public void test(){
//
//    }
//
//    @Before("test()")
//    public void beforeAdvice(){
//        System.out.println("before advice");
//    }
//
//    @Around("test()")
//    public void aroundAdvice(ProceedingJoinPoint proceedingJoinPoint){
//        System.out.println("this is before");
//
//        try {
//            proceedingJoinPoint.proceed();
//        } catch (Throwable e) {
//            throw new RuntimeException(e);
//        }
//
//        System.out.println("this is after");
//    }
//
//    @After("test()")
//    public void afterAdvice(){
//        System.out.println("after advice");
//    }
//
//
//
//}
