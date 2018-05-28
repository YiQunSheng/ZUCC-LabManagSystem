package com.zucc.sheng.serviceImpl;

import com.zucc.sheng.dao.useRecordDao;
import com.zucc.sheng.model.userecord;
import com.zucc.sheng.service.stuService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("stuService")
public class stuServiceImpl implements stuService {
    @Resource(name="useRecordDao")
    private useRecordDao useRecordDao;
    @Override
    public void addUseRecord(userecord userRecord) {
        this.useRecordDao.userStart(userRecord);
    }
    @Override
    public void updateUseRecord(userecord userecord,String userId) {
         userecord currentUserecord=this.useRecordDao.getcurrentUseRecordByUserId(userId);
         currentUserecord.setOutTime(userecord.getOutTime());
         this.useRecordDao.userEnd(currentUserecord);
    }

    @Override
    public userecord getcurrentUseRecordByUserId(String userid) {
        return this.useRecordDao.getcurrentUseRecordByUserId(userid);
    }
}
