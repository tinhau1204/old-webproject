package com.item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import com.data.HibernateUntil;

public class ItemDAO {
    @SuppressWarnings("unchecked")
    public  List<Item> SelectAllTheProduct()
    {
        try
        {
            return HibernateUntil.getSessionFacoty().openSession()
            .createQuery("FROM Item").getResultList();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public void addItem(Item item)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.save(item);
            transaction.commit();
        }catch(Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void updateItem(Item item)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.update(item);
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

    public void deleteItemById(int id)
    {
        Transaction transaction = null;
        Item item = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            item = session.get(Item.class, id);
            if(item != null)
            {
                session.delete(item);
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
}
