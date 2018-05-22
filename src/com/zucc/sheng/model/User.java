package com.zucc.sheng.model;

import java.util.HashSet;
import java.util.Set;

public class User {
    private String userName;
    private String userId;
    private String pwd;
    private String role;
    private Set<userecord> userecords = new HashSet<userecord>();

    public Set<userecord> getUserecords() {
        return userecords;
    }

    public void setUserecords(Set<userecord> userecords) {
        this.userecords = userecords;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public User() {

    }
}
