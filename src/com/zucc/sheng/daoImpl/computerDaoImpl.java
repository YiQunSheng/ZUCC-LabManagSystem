package com.zucc.sheng.daoImpl;


import com.zucc.sheng.dao.computerDao;
import com.zucc.sheng.model.computer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("computerDao")
public class computerDaoImpl implements computerDao {
   /* public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }
    Session session=getSession();
    private static SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
    Transaction transaction = session.beginTransaction();*/
    @Override
    public computer getComputerById(String computerId) {
        SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from computer where computerId = ?");
        query.setParameter(0, computerId);
        List<computer> computers = query.list();
        transaction.commit();
        session.close();
        return computers.get(0);
    }

    @Override
    public List<computer> getComputerInLab(String labId) {
        SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(" from computer where labId = ?");
        query.setParameter(0, labId);
        List<computer> computers = query.list();
        transaction.commit();
        session.close();
        return computers;
    }

    @Override
    public boolean addComputer(computer computer) {
        SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
            session.save(computer);
            transaction.commit();
            session.close();
            return true;
    }

    @Override
    public boolean deleteComputer(String computerId) {
        SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        computer computer = new computer();
        computer.setComputerId(computerId);
        session.delete(computer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean updateComputer(computer computer) {
        SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.update(computer);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public List<computer> getAllComputers() {
        SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery("from computer");
        List<computer> computers= query.list();
        transaction.commit();
        session.close();
        return computers;

    }
}
