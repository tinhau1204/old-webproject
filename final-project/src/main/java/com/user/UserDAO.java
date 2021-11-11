package com.user;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.data.HibernateUntil;
import com.user.User;

public class UserDAO {
    public static User selectUser(String email)
    {
        Transaction transaction = null;
        User user = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            user = (User) session.createQuery(" FROM User u WHERE u.email = :email")
            .setParameter("email", email).uniqueResult();
        }
        catch( Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user;
    }

    public static boolean emailExists(String email)
    {
        User u = selectUser(email);
        return u != null;
    }

    public static boolean checkLoginUser(String email, String pass)    // Use to login
    {
        Transaction transaction = null;
        User user = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            user = (User) session.createQuery(" FROM User u WHERE u.email = :email AND u.pass = :pass")
            .setParameter("email", email).setParameter("pass", pass).uniqueResult();
        }
        catch( Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return user != null;
    }

    public static void addUser(User user)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            
            session.save(user);
            transaction.commit();
            
        }
        catch(Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
