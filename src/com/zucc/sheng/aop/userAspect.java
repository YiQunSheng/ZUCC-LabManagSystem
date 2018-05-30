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
        System.out.println("ǰ��֪ͨ��ģ��ִ��Ȩ�޼��");
        System.out.println("Ŀ�����ǣ�" + joinPoint.getTarget());

    }

    @After("execution(* com.zucc.sheng.dao.UserDao.addUser(..))")
    public void myAfterReturnning(JoinPoint joinPoint) {
        System.out.println("����֪ͨ��ģ���¼��־");
        System.out.println("Ŀ�����ǣ�" + joinPoint.getTarget());

    }
    public Object myAround(ProceedingJoinPoint proceedingJoinPoint ) throws Throwable {
        System.out.println("���ƿ�ʼ");
        Object obj = proceedingJoinPoint.proceed();
        System.out.println("���ƽ���");
        return obj;

    }

    public void myAfterThrowing(JoinPoint joinPoint, Throwable throwable) {
        System.out.println("Error :" + throwable.getMessage());
    }
@After("execution(* com.zucc.sheng.daoImpl.UserDaoImpl.addUser(..))")
    public void myAfter() {
        System.out.println("����֪ͨ�����");
    }
}