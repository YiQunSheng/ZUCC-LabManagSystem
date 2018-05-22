package com.zucc.sheng.daoImpl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class testUtil {
    @Resource(name = "UserDao")
    private UserDaoImpl userDao;


    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("application.xml");

    }
}
