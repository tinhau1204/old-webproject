package com.tree;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import com.data.HibernateUntil;

public class TreeDAO {
    @SuppressWarnings("unchecked")
    public List<Tree> SelectAllTree()
    {
        try{
            return HibernateUntil.getSessionFacoty().openSession()
            .createQuery("FROM Tree").getResultList();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void addTree(Tree tree)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.save(tree);
            transaction.commit();
        }
        catch(Exception e)
        {
            if(transaction != null)
            {
                e.printStackTrace();
            }
        }
    }

    public void updateTree(Tree tree)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.update(tree);
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

    public void deleteTreeById(int id)
    {
        Transaction transaction = null;
        Tree tree = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            tree = session.get(Tree.class, id);
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
