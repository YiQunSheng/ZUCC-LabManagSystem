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
        System.out.println("前置通知：模拟执行权限检查");
        System.out.println("目标类是：" + joinPoint.getTarget());

    }

    @After("execution(* com.zucc.sheng.dao.UserDao.addUser(..))")
    public void myAfterReturnning(JoinPoint joinPoint) {
        System.out.println("后置通知：模拟记录日志");
        System.out.println("目标类是：" + joinPoint.getTarget());

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
