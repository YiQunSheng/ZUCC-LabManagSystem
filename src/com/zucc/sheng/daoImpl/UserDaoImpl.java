package com.zucc.sheng.daoImpl;

import com.zucc.sheng.dao.UserDao;
import com.zucc.sheng.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
    private static SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();

    public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }
    Session session=getSession();
    Transaction transaction = session.beginTransaction();
    @Override
    public void addUser(User user) {

        session.save(user);
        transaction.commit();
        session.close();
    }

    @Override
    public List<User> getUser() {
        List<User> pubs
                =session.createQuery("from User").list();
        return pubs;

    }
}
