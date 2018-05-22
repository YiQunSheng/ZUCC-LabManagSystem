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
    /*public static Session getSession(){
            Session session = sessionFactory.openSession();
            return session;
        }
        Session session=getSession();*/
    private static SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();
    Session session = sessionFactory.openSession();
    Transaction transaction = session.beginTransaction();
    @Override
    public boolean addUser(User user) {

        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public User getUserById(String userId) {
        return null;
    }

    @Override
    public User getUserByName(String userName) {
        return null;
    }

    @Override
    public List<User> getUser() {
        List<User> pubs
                =session.createQuery("from User").list();
        return pubs;

    }

    @Override
    public boolean deleteUser(String userId) {
        return false;
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

}
