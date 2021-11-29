package com.data;

import java.util.Properties;

import com.cart.Cart;
import com.item.Item;
import com.tree.Tree;
import com.user.User;
import com.userInfo.UserInfo;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

public class HibernateUntil {
	private static SessionFactory sessionFactory;

	// public static SessionFactory getSessionFacoty() {
	// 	if (sessionFactory == null) {
	// 		try {
	// 			Configuration configuration = new Configuration();
	// 			Properties settings = new Properties();
	// 			settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
	// 			settings.put(Environment.DRIVER, "org.postgresql.Driver");
	// 			settings.put(Environment.URL, "jdbc:postgresql://localhost:5432/postgres");
	// 			settings.put(Environment.USER, "postgres");
	// 			settings.put(Environment.PASS, "2762001T");
	// 			settings.put(Environment.SHOW_SQL, "true");
	// 			settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

	// 			configuration.setProperties(settings);
	// 			configuration.addAnnotatedClass(UserInfo.class);
	// 			configuration.addAnnotatedClass(User.class);
	// 			configuration.addAnnotatedClass(Item.class);
	// 			configuration.addAnnotatedClass(Tree.class);
	// 			configuration.addAnnotatedClass(Cart.class);
	// 			ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
	// 					.applySettings(configuration.getProperties()).build();
	// 			System.out.println("Hibernate Java Config serviceRegistry created");
	// 			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
	// 			return sessionFactory;
	// 		} catch (Exception e) {
	// 			e.printStackTrace();
	// 		}

	// 	}
	// 	return sessionFactory;
	// }


	//for heroku
	public static SessionFactory getSessionFacoty() {
		if (sessionFactory == null) {
			try {
				Configuration configuration = new Configuration();
				Properties settings = new Properties();
				settings.put(Environment.DIALECT, "org.hibernate.dialect.PostgreSQLDialect");
				settings.put(Environment.DRIVER, "org.postgresql.Driver");
				settings.put(Environment.URL, "jdbc:postgresql://ec2-3-95-130-249.compute-1.amazonaws.com:5432/d8qiirj2ev2u8k");
				settings.put(Environment.USER, "ltfayypjakbyji");
				settings.put(Environment.PASS, "e51fbadd2c40d9c783dbf5aadc74c5a7c88eecde5035924b35823204f302d0e1");
				settings.put(Environment.SHOW_SQL, "true");
				settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
				settings.put(Environment.HBM2DDL_AUTO,"update");

				configuration.setProperties(settings);
				configuration.addAnnotatedClass(UserInfo.class);
				configuration.addAnnotatedClass(User.class);
				configuration.addAnnotatedClass(Item.class);
				configuration.addAnnotatedClass(Tree.class);
				configuration.addAnnotatedClass(Cart.class);
				ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
						.applySettings(configuration.getProperties()).build();
				System.out.println("Hibernate Java Config serviceRegistry created");
				sessionFactory = configuration.buildSessionFactory(serviceRegistry);
				return sessionFactory;
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return sessionFactory;
	}
}
