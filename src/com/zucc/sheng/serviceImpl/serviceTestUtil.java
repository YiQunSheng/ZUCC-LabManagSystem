package com.zucc.sheng.serviceImpl;

import com.zucc.sheng.dao.UserDao;
import com.zucc.sheng.daoImpl.UserDaoImpl;
import com.zucc.sheng.daoImpl.labDaoImpl;
import com.zucc.sheng.model.User;

import javax.annotation.Resource;

public class serviceTestUtil {
    @Resource(name = "UserService")
    private UserServiceImpl userService;

    public static void main(String[] args) {
        UserServiceImpl userService = new UserServiceImpl();
        /*User user = userService.login("10000001", "12");
        System.out.println(user.getUserName());
        System.out.println(user.getRole());*/
        User user = new User();
        user.setRole("stu");
        user.setUserId("10000005");
        user.setPwd("123");
        user.setUserName("zz2");
        userService.updateUser(user);
    }
}
