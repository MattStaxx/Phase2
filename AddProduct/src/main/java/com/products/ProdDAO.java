package com.products;


import java.math.BigDecimal;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

// Product access object to create a session and carry out a transaction with the database
public class ProdDAO {

	public void addProdDetails(String name, String color, String price) {
		
		try {
			Configuration configuration = new Configuration();
			SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product prod = new Product();
			prod.setName(name);
			prod.setColor(color);
			prod.setPrice(BigDecimal.valueOf(Double.parseDouble(price)));
			session.save(prod);
			transaction.commit();
			session.close();
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}
}