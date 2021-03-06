package com.zucc.sheng.service;

import com.zucc.sheng.model.User;

import java.util.List;

public interface UserService {
    public void addUser(User user);

    public List<User> getAllUser();

    public String getAllUserName();

    User login(String userId,String pwd);

    boolean deleteUser(String userId);

    boolean updateUser(User user);

    User getUserById(String userId);
}
