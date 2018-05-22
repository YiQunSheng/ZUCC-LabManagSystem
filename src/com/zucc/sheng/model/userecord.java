package com.zucc.sheng.model;

import java.sql.Timestamp;

public class userecord {
    private int recordId;
    private Timestamp inTime;
    private Timestamp outTime;

    private User user;
    private lab lab;
    private computer computer;

    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public Timestamp getInTime() {
        return inTime;
    }

    public void setInTime(Timestamp inTime) {
        this.inTime = inTime;
    }

    public Timestamp getOutTime() {
        return outTime;
    }

    public void setOutTime(Timestamp outTime) {
        this.outTime = outTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public com.zucc.sheng.model.lab getLab() {
        return lab;
    }

    public void setLab(com.zucc.sheng.model.lab lab) {
        this.lab = lab;
    }

    public com.zucc.sheng.model.computer getComputer() {
        return computer;
    }

    public void setComputer(com.zucc.sheng.model.computer computer) {
        this.computer = computer;
    }
}
