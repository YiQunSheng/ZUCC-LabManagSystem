package com.zucc.sheng.service;

import com.zucc.sheng.model.lab;

import java.util.List;

public interface labService {
    public void addLab(lab lab);

    public List<lab> getAlllab();


    boolean deleteLab(String labId);

    boolean updateLab(lab lab );

    lab getLabById(String labId);

    int getUsableComp(String labId);
}
