package com.ohgiraffers.section01.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

// 이 클래스가 공통 기능을 정의한 Aspect 클래스임을 나타낸다.
@Aspect
@Component
public class LoggingAspect {

    // 핵심 : '어디에' 공통 기능을 적용할지 범위를 지정
    @Pointcut("execution(* com.ohgiraffers.section01.aop.*Service.*(..))")   // *Service -> Service로 끝나는 모든 클래스 // *(..) -> 모든 메소드
    public void logPointcut(){}

    @Before("logPointcut()")    // Pointcut으로 지정된 메소드가 실행되기 '전'에 동작할 공통 기능
    public void logBefore(JoinPoint joinPoint){     // JoinPoint : 현재 실행되는 메소드의 정보를 담고있는 객체
        System.out.println("Before joinPoint.getSignature() : " + joinPoint.getSignature());
        if(joinPoint.getArgs().length > 0){
            System.out.println("Before joinPoint.getArgs()[0] " + joinPoint.getArgs()[0]);
        }
    }

    @After("logPointcut()")
    public void logAfter(JoinPoint joinPoint){
        System.out.println("After joinPoint.getTarget() : " + joinPoint.getTarget());
        System.out.println("After joinPoint.getSignature() : " + joinPoint.getSignature());
    }

    // returning 속성은 리턴값으로 반환되는 애를 객체로 받는것이다.
    // 리턴 값으로 받아올 객체의 매개변수 이름과 동일해야 한다.
    @AfterReturning(pointcut = "logPointcut() ", returning = "result" )
    public void logAfterReturning(JoinPoint joinPoint, Object result) {
        System.out.println("After Returning Result : " + result);
    }

    // 예외가 발생했을 때만
    @AfterThrowing(pointcut = "logPointcut()", throwing = "exception")
    public void logAfterThrowing(Throwable exception){
        System.out.println("AfterThrowing 동작");
        System.out.println(exception);
    }

}
