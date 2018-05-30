package com.zucc.sheng.dao;

        import com.zucc.sheng.model.userecord;

        import java.util.List;

public interface useRecordDao {
    public boolean userStart(userecord userRecord);
    public boolean userEnd(userecord userecord);
    public userecord getcurrentUseRecordByUserId(String userid);
    List<userecord> getUserecordsByUserId(String userId);
}
