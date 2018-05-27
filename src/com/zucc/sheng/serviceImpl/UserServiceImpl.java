package com.zucc.sheng.serviceImpl;

import com.zucc.sheng.dao.UserDao;
import com.zucc.sheng.daoImpl.UserDaoImpl;
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
        return userDao.getAllUser();
    }

    @Override
    public String getAllUserName() {
        List<User> user=userDao.getAllUser();
        return user.get(0).getUserName();
    }

    @Override
    public User login(String userId, String pwd) {
//        UserDaoImpl userDao1 = new UserDaoImpl();
        User user = userDao.getUserById(userId);
//        return user;
        //如果用户不存在，返回null，如果存在但密码错误，返回用户，但是role=error，正确返回用户。
        if(user==null) return null;
        else if(user.getPwd().equals(pwd))
        {

            return user;
        }
        else {
            User user1 = new User();
            user1.setRole("error");
            return user1;
        }
    }

    @Override
    public boolean deleteUser(String userId) {
//        UserDaoImpl userDao1 = new UserDaoImpl();
        return userDao.deleteUser(userId);
    }

    @Override
    public boolean updateUser(User user) {
        return userDao.updateUser(user);
    }

    @Override
    public User getUserById(String userId) {
        return userDao.getUserById(userId);
    }
}
