package com.tree;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

import com.data.HibernateUntil;
import com.item.Item;

public class TreeDAO {
    @SuppressWarnings("unchecked")
    public static List<Tree> SelectAllTree()
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

    public static void addTree(Tree tree)
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

    public static void updateTree(Tree tree)
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

    public static void deleteTreeById(int id)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            
            transaction = session.beginTransaction();
            Tree tree = session.get(Tree.class, id);
            if(tree != null)
            {
                session.delete(tree);
            }
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


    public static Tree selectTreeByName(String name)
    {
        Transaction transaction = null;
        Tree tree = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            tree = (Tree) session.createQuery("FROM Tree u WHERE u.treeName = :name")
            .setParameter("name",name).uniqueResult();
        }
        catch(Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return tree;
    }

    public static Tree selectTreeByNameAndBrand(String name, String brand)
    {
        Transaction transaction = null;
        Tree tree = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            tree = (Tree) session.createQuery("FROM Tree u WHERE u.treeName = :name AND u.brand = :brand")
            .setParameter("name",name).setParameter("brand", brand).uniqueResult();
        }
        catch(Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return tree;
    }

    public static boolean existTree(String name, String brand)
    {
        Tree tree = selectTreeByNameAndBrand(name,brand);
        return tree != null;
    }

    public static Tree selectTreeById(int id)
    {
        Transaction transaction = null;
        Tree tree = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            tree = (Tree) session.createQuery("FROM Tree u WHERE u.tId = :id")
            .setParameter("id",id).uniqueResult();
        }
        catch(Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return tree;
    }

    @SuppressWarnings("unchecked")
    public static List<Tree> loadFiveFirstTree()
    {
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            return HibernateUntil.getSessionFacoty().openSession()
            .createQuery("FROM Tree u WHERE u.amount > 0").setMaxResults(5).getResultList();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }



}
