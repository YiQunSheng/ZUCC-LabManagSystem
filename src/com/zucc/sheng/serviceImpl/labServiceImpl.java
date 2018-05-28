package com.zucc.sheng.serviceImpl;

import com.zucc.sheng.model.lab;
import com.zucc.sheng.service.labService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Service;
import com.zucc.sheng.dao.labDao;
import javax.annotation.Resource;
import java.util.List;
@Service("labService")
public class labServiceImpl implements labService {
     @Resource(name="labDao")
     private labDao labDao;

    public labDao getLabDao() {
        return labDao;
    }

    public void setLabDao(labDao labDao) {
        this.labDao = labDao;
    }

    @Override
    public void addLab(lab lab) {
       this.labDao.addLab(lab);
    }

    @Override
    public List<lab> getAlllab() {
        return this.labDao.getAllLab();
    }

    @Override
    public boolean deleteLab(String labId){
        return this.labDao.deleteLab(labId);
    }

    @Override
    public boolean updateLab(lab lab) {

        return this.labDao.editLab(lab);
    }

    @Override
    public lab getLabById(String labId) {
        return this.labDao.getLabById(labId);
    }

    @Override
    public int getUsableComp(String labId) {
        return labDao.getUsableComp(labId);
    }
}
