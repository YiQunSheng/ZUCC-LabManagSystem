package com.zucc.sheng.daoImpl;

import com.zucc.sheng.dao.UserDao;
import com.zucc.sheng.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("UserDao")
public class UserDaoImpl implements UserDao {
    public static Session getSession(){
            Session session = sessionFactory.openSession();
            return session;
        }
        Session session=getSession();
    private static SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();
    Transaction transaction = session.beginTransaction();
    @Override
    public boolean addUser(User user) {
        /*SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
        try {
            session.save(user);
            transaction.commit();
            session.close();
            return true;
        }catch (Exception e){
            transaction.rollback();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
        return false;

    }

    @Override
    public boolean deleteUser(String userId) {
        /*SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
        User user = new User();
        user.setUserId(userId);
        session.delete(user);
        transaction.commit();
        session.close();
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        /*SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
        session.update(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public User getUserById(String userId) {
        /*SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
        Query query = session.createQuery("from User where userId = ?");
        query.setParameter(0, userId);
        List<User> users = query.list();
        transaction.commit();
        session.close();
        return users.get(0);
    }

    @Override
    public User getUserByName(String userName) {
        Query query = session.createQuery("from User where userName = ?");
        query.setParameter(0, userName);
        List<User> users = query.list();
        transaction.commit();
        session.close();
        return users.get(0);
    }

    @Override
    public List<User> getAllUser() {
        /*SessionFactory sessionFactory
                = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();*/
        Query query = session.createQuery("from User ");
        List<User> users = query.list();
        transaction.commit();
        session.close();
        return users;
    }
/*//    Session session = sessionFactory.openSession();

    @Override
    public boolean addUser(User user) {

        session.save(user);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public User getUserById(String userId) {
        try {
            Query query = session.createQuery("from user where userId = ?");
            query.setParameter(0, userId);
            List<User> users = query.list();
            transaction.commit();
            return users.get(0);
        }catch (Exception e){
            transaction.rollback();
        }
        finally {
            session.close();
            sessionFactory.close();
        }
        return null;
    }*/


}
