package com.cart;

import org.hibernate.Session;
import org.hibernate.Transaction;
import java.util.Date;
import java.sql.Timestamp;

import com.data.HibernateUntil;

public class CartDAO {
	public static Cart selectCartByUid(int uid) {
		Transaction transaction = null;
		Cart cart = null;
		try (Session session = HibernateUntil.getSessionFacoty().openSession()) {
			transaction = session.beginTransaction();
			cart = (Cart) session.createQuery("FROM Cart c WHERE c.user.uid=:uid")
					.setParameter("uid", uid).uniqueResult();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return cart;
	}

	public static boolean checkExistCart(int uid) {
		Cart cart = selectCartByUid(uid);
		return cart != null;
	}

	public static void addCart(Cart cart) {
		Transaction transaction = null;
		try (Session session = HibernateUntil.getSessionFacoty().openSession()) {
			transaction = session.beginTransaction();
			session.save(cart);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				e.printStackTrace();
			}
		}
	}

	public static void updateCart(Cart cart) {
		Transaction transaction = null;
		try (Session session = HibernateUntil.getSessionFacoty().openSession()) {
			transaction = session.beginTransaction();
			session.update(cart);
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

	public static void updateCheckCart(Cart cart) {
		Transaction transaction = null;
		String state = "paid";
		try (Session session = HibernateUntil.getSessionFacoty().openSession()) {
			transaction = session.beginTransaction();
			int id = cart.getId();

			// date
			Date date = new Date();
			Timestamp paidDate = new Timestamp(date.getTime());	
			session.createQuery("UPDATE Item i SET i.state=:state, i.dayPaid=:daypaid WHERE i.cart.cid=:id")
					.setParameter("state", state).setParameter("daypaid", paidDate).setParameter("id", id)
					.executeUpdate();
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
	}

}
