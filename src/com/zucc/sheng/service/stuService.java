package com.zucc.sheng.service;
import com.zucc.sheng.model.userecord;

import java.util.List;

public interface stuService
{
    public void addUseRecord(userecord userRecord);
    public void updateUseRecord(userecord userecord,String userId);
    public userecord getcurrentUseRecordByUserId(String userid);

    List<userecord> getUserecordsByUserId(String userId);
}
