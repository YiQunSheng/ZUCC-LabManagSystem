package com.zucc.sheng.dao;

import com.zucc.sheng.model.lab;

import java.util.List;

public interface labDao {
    public lab getLabById(String LabId);
    public void  addLab(lab lab);
    public boolean deleteLab(String labId);
    public boolean  editLab(lab lab);
    public List<lab> getAllLab( );
}
