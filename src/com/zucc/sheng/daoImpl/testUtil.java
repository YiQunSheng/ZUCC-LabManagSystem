package com.zucc.sheng.daoImpl;

import com.zucc.sheng.dao.UserDao;
import com.zucc.sheng.model.User;
import com.zucc.sheng.model.computer;
import com.zucc.sheng.model.lab;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.annotation.Resource;
import java.util.List;

public class testUtil {
    @Resource(name = "UserDao")
    private UserDaoImpl userDao;

    public void add() {
        User user = new User();
        user.setUserId("10000003");
        user.setUserName("SunZhao");
        user.setPwd("123");
        user.setRole("stu");
        userDao.addUser(user);
    }

    public User search(String id) {
        User user = userDao.getUserById(id);
        return user;
    }

    public void pri() {
        System.out.println("fuck world");
    }
    public static void main(String[] args) {
        UserDaoImpl userDao = new UserDaoImpl();
        labDaoImpl labDao = new labDaoImpl();
        /*computerDaoImpl computerDao = new computerDaoImpl();
//        System.out.println(userDao.getUser("10000002").getUserName());
//        User user = userDao.getUser("10000003");
//        user.setUserName("SunZhao");
//        userDao.updateUser(user);
       *//* List<User> users = userDao.getAllUser();
        for (int i=0;i<users.size();i++) {
            System.out.println(users.get(i).getUserName());

        }*//*
        List<computer> computers = computerDao.getComputerInLab("Lab00001");
        System.out.println(computers.get(0).getIpAddress());
        computer computer = new computer();
        computer.setComputerId("comp0003");
        computer.setIpAddress("192.168.0.3");
        lab lab = new lab();
        lab.setLabId("Lab00002");
        computer.setLab(lab);
        computer.setStatus(1);
        computerDao.addComputer(computer);*/
//        User user = userDao.getUserById("10000001");
//        System.out.println(user.getUserName());
        System.out.println(labDao.getUsableComp("Lab00001"));
    }
}
