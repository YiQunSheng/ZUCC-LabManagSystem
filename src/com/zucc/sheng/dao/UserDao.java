package com.zucc.sheng.dao;

import com.zucc.sheng.model.User;

import java.util.List;

public interface UserDao {
    public void addUser(User user);

    public List<User> getUser();
}
