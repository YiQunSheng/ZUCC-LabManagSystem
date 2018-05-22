package com.zucc.sheng.model;

import java.util.HashSet;
import java.util.Set;

public class lab {
    private String labId;
    private String location;
    private int size;
    private int userAmount;
    private Set<computer> computers = new HashSet<computer>();
    private Set<userecord> userecords = new HashSet<userecord>();

    public Set<userecord> getUserecords() {
        return userecords;
    }

    public void setUserecords(Set<userecord> userecords) {
        this.userecords = userecords;
    }

    public Set<computer> getComputers() {
        return computers;
    }

    public void setComputers(Set<computer> computers) {
        this.computers = computers;
    }

    public String getLabId() {
        return labId;
    }

    public void setLabId(String labId) {
        this.labId = labId;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getUserAmount() {
        return userAmount;
    }

    public void setUserAmount(int userAmount) {
        this.userAmount = userAmount;
    }
    public lab (){

    }
}
