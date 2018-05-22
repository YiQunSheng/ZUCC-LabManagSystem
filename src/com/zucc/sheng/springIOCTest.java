package com.zucc.sheng;

import com.zucc.sheng.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;

public class springIOCTest {

    public static void main(String[] args) {
        ApplicationContext cxt = new ClassPathXmlApplicationContext("application.xml");
        UserService userService = (UserService) cxt.getBean("UserService");
        System.out.println(userService.getAllUserName());
    }
}
