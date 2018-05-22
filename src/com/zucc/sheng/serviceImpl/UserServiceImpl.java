package com.zucc.sheng.serviceImpl;

import com.zucc.sheng.dao.UserDao;
import com.zucc.sheng.model.User;
import com.zucc.sheng.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("UserService")
public class UserServiceImpl implements UserService {
    @Resource(name = "UserDao")
    private UserDao userDao;


    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public List<User> getAllUser() {
        return userDao.getUser();
    }

    @Override
    public String getAllUserName() {
        List<User> user=userDao.getUser();
        return user.get(0).getUserName();
    }
}
