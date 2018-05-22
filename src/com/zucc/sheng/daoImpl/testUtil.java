package com.zucc.sheng.daoImpl;

import com.zucc.sheng.dao.UserDao;
import com.zucc.sheng.model.User;
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
//        System.out.println(userDao.getUser("10000002").getUserName());
//        User user = userDao.getUser("10000003");
//        user.setUserName("SunZhao");
//        userDao.updateUser(user);
        List<User> users = userDao.getAllUser();
        for (int i=0;i<users.size();i++) {
            System.out.println(users.get(i).getUserName());

        }

    }
}
