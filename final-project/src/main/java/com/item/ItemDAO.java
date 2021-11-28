package com.item;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

import com.data.HibernateUntil;

public class ItemDAO {
        /**
     * Get all products
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<Item> SelectAllTheProduct()
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

    public static void addItem(Item item)
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

    public static void updateItem(Item item)
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

    public static void deleteItemById(int id)
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

    public static Item getItemById(int id)
    {
        Transaction transaction = null;
        Item item = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            item = (Item) session.createQuery("FROM Item u WHERE u.id = :id")
            .setParameter("id", id).uniqueResult();
        }
        catch(Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return item;
    }

    public static Item selectUnpaidItemById(int cartId, int itemId )
    {
        Transaction transaction = null;
        Item item = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            String state = "order";
            transaction = session.beginTransaction();
            item = (Item) session.createQuery("FROM Item i WHERE i.cart.cid=:cid AND i.state=:state AND i.tree.tId=:tid ")
            .setParameter("cid", cartId).setParameter("tid", itemId).setParameter("state", state).uniqueResult();
        }
        catch(Exception e)
        {
            if(transaction != null)
            {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        return item;
    }

    public static boolean checkUnpaidItemById(int cartId, int itemId)
    {
        Item item = selectUnpaidItemById(cartId, itemId);
        return item != null;
    }

    public static void deleteItemByTreeId(int treeId)
    {
        Transaction transaction = null;
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Item i WHERE i.tree.tId = :tid")
            .setParameter("tid", treeId).executeUpdate();
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

    @SuppressWarnings("unchecked")
    public static List<Item> SelectAllUserProducts(int cartId)
    {
        String state = "order";
        try
        {
            return HibernateUntil.getSessionFacoty().openSession()
            .createQuery("FROM Item i WHERE i.cart.cid = :cid AND state = :state")
            .setParameter("cid", cartId).setParameter("state",state).getResultList();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    public static void deleteAllUnpaidItems(int cartId)
    {
        Transaction transaction = null;
        String state = "order";
        try(Session session = HibernateUntil.getSessionFacoty().openSession())
        {
            transaction = session.beginTransaction();
            session.createQuery("DELETE FROM Item i WHERE i.cart.cid = :cid AND i.state = :state")
            .setParameter("cid", cartId).setParameter("state", state).executeUpdate();;
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
