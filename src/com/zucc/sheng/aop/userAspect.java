package com.zucc.sheng.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class userAspect {
    @Before("execution(* com.zucc.sheng.dao.UserDao.addUser(..))")
    public void beforeAdd(JoinPoint joinPoint) {
        System.out.println("BeforeAOP:This is before the method ");
        System.out.println("The Target Class is ：" + joinPoint.getTarget());

    }

    @After("execution(* com.zucc.sheng.dao.UserDao.addUser(..))")
    public void myAfterReturnning(JoinPoint joinPoint) {
        System.out.println("AfterAOP ：This Method is Successfully finished");
        System.out.println("The Target Class is：" + joinPoint.getTarget());

    }
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
        System.out.println("环绕开始");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("环绕结束");
        return obj;

    }

    public void myAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("Error :" + throwable.getMessage());
    }
@After("execution(* com.zucc.sheng.daoImpl.UserDaoImpl.addUser(..))")
    public void myAfter() {
        System.out.println("最终通知，完成");
    }
}
