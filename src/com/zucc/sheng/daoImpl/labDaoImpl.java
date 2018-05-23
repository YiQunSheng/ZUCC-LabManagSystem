package com.zucc.sheng.daoImpl;

import com.zucc.sheng.dao.labDao;
import com.zucc.sheng.model.lab;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("labDao")
public class labDaoImpl implements labDao {
    private static SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();

    public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }
    @Override
    public lab getLabById(String LabId) {
         Session session=getSession();
        Transaction transaction=session.beginTransaction();
        String hql="from lab where id=?";
        lab lab=(lab)session.createQuery(hql).setParameter(0,LabId).uniqueResult();
        transaction.commit();
        session.close();
        return lab;
    }

    @Override
    public void addLab(lab lab) {
      Session session=getSession();
      Transaction transaction=session.beginTransaction();
      session.save(lab);
      transaction.commit();
      session.close();
    }

    @Override
    public boolean deleteLab(String labId) {
        Session session=getSession();
        Transaction transaction=session.beginTransaction();
        lab lab=(lab)session.get(lab.class,labId);
        session.delete(lab);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean editLab(lab lab) {
        Session session=getSession();
        Transaction transaction=session.beginTransaction();
        session.update(lab);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<lab> getAllLab() {
        Session session=getSession();
        Transaction transaction=session.beginTransaction();
        List<lab> labs=session.createQuery("from lab").list();
        return labs;
    }
}
