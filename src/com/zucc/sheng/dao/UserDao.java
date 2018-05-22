package com.zucc.sheng.dao;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.zucc.sheng.model.User;

import java.util.List;

public interface UserDao {
    public boolean addUser(User user);

    public boolean deleteUser(String userId);

    public boolean updateUser(User user);

    public User getUserById(String userId);

    public User getUserByName(String userName);

    public List<User> getAllUser();
}
