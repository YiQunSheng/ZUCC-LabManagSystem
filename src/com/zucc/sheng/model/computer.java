package com.zucc.sheng.model;

import java.util.HashSet;
import java.util.Set;

public class computer {
    private String computerId;
    private String ipAddress;
    private int  status;
    private lab lab;
    private Set<userecord> userecords = new HashSet<userecord>();

    public Set<userecord> getUserecords() {
        return userecords;
    }

    public void setUserecords(Set<userecord> userecords) {
        this.userecords = userecords;
    }

    public com.zucc.sheng.model.lab getLab() {
        return lab;
    }

    public void setLab(com.zucc.sheng.model.lab lab) {
        this.lab = lab;
    }

    public String getComputerId() {
        return computerId;
    }

    public void setComputerId(String computerId) {
        this.computerId = computerId;
    }



    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public computer() {

    }
}
