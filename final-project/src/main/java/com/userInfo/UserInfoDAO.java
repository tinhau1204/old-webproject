package com.userInfo;

import org.hibernate.Session;
import org.hibernate.Transaction;


import com.data.HibernateUntil;


public class UserInfoDAO 
{
    public static void updateUserInfo(UserInfo userInfo)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.saveOrUpdate(userInfo);
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

    public static void InsertUserInfo(UserInfo userInfo)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.save(userInfo);
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

    public static UserInfo selectUserInfoById(int id)
    {
        Transaction transaction = null;
        UserInfo userInfo = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            userInfo = (UserInfo) session.createQuery(" FROM UserInfo u WHERE u.uid = :id")
            .setParameter("id", id).uniqueResult();
        }
        catch( Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return userInfo;
    }
    public static boolean checkUserInfo(int id)
    {
        UserInfo u = selectUserInfoById(id);
        return u != null;
    }
    }
