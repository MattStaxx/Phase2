package com.products;


import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class ProdDAO {

	public static void addProdDetails(int id, String name, String color, double price) {
		
		try {
			Configuration configuration = new Configuration();
			SessionFactory sessionFactory = configuration.configure("hibernate.cfg.xml").buildSessionFactory();
			Session session = sessionFactory.openSession();
			Transaction transaction = session.beginTransaction();
			Product prod = new Product();
			prod.setId(id);
			prod.setName(name);
			prod.setColor(color);
			prod.setPrice(price);
			session.save(prod);
			transaction.commit();
			session.close();
		} catch(HibernateException e) {
			System.out.println(e.getMessage());
			System.out.println("error");
		}
	}
}