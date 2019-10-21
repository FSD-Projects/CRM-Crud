package comm.example.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import comm.example.model.Customer;


public class HibernateUtilFactory {
	private static Session session;

	public static Session getMySession() {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Customer.class)
				.buildSessionFactory();
		session = factory.openSession();
		return session;
	}
}
