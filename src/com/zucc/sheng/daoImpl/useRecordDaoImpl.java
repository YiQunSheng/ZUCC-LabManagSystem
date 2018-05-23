package com.zucc.sheng.daoImpl;
import com.zucc.sheng.dao.useRecordDao;
import com.zucc.sheng.model.userecord;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.omg.CORBA.TRANSACTION_MODE;
import org.springframework.stereotype.Repository;
import sun.plugin2.os.windows.SECURITY_ATTRIBUTES;

import java.util.List;

@Repository("useRecordDao")
public class useRecordDaoImpl implements useRecordDao {


    private static SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();

    public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }

    @Override
    public boolean userStart(userecord userRecord) {
        Session session=getSession();
        Transaction transaction=session.beginTransaction();
        session.save(userRecord);
        transaction.commit();
        session.close();
        return true;
    }
    @Override
    public userecord getcurrentUseRecordByUserId(String userid) {
        Session session=getSession();
        Transaction transaction=session.beginTransaction();
        String hql="from userecord where userid=? order by inTime";
        Query query=session.createQuery(hql).setParameter(0,userid);
        List<userecord> userecords=query.list();
        userecord userecord=new userecord();
        int lastIndex=userecords.size()-1;
        userecord=userecords.get(lastIndex);
        transaction.commit();
        session.close();
        return userecord;
    }
    @Override
    public boolean userEnd(userecord userecord) {
        Session session=getSession();
        Transaction transaction=session.beginTransaction();
        session.update(userecord);
        transaction.commit();
        session.close();
        return true;
    }
}
