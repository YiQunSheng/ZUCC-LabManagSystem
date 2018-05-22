package com.zucc.sheng.model;
import com.sun.org.apache.bcel.internal.generic.IUSHR;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HibernateUtils {
    private static SessionFactory sessionFactory
            = new Configuration().configure().buildSessionFactory();
    public static Session getSession(){
        Session session = sessionFactory.openSession();
        return session;
    }
    public static void main(String[] args){
        Session session=getSession();
        Transaction transaction = session.beginTransaction();
        /*User user = new User();
        user.setUserId("10000003");
        user.setUserName("ZZZ");

        session.save(user);
        transaction.commit();
        session.close();*/

        /*List<User> pubs
                =session.createQuery("from User").list();//Is the Name of Class but not the Name OF Table!!!*/
        List<computer> coms = session.createQuery("from computer").list();
        /*System.out.println(pubs.get(0).getUserName());
        System.out.println(pubs.get(0).getUserId());*/
        System.out.println(coms.get(0).getLabId());
    }

}

