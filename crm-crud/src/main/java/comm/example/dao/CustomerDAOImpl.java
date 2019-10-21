package comm.example.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Criteria;
import org.hibernate.Session;

import comm.example.factory.HibernateUtilFactory;
import comm.example.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	private static Session session;

	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		session = HibernateUtilFactory.getMySession();
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer", Customer.class);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List<Customer> lst = query.getResultList();
		return lst;
	}

	public void createCustomer(Customer customer) {
		// TODO Auto-generated method stub
		session = HibernateUtilFactory.getMySession();
		session.getTransaction().begin();
		session.save(customer);
		session.getTransaction().commit();
	}

	@Override
	public void deleteCustomer(Customer customer) {
		// TODO Auto-generated method stub
		session = HibernateUtilFactory.getMySession();
		session.getTransaction().begin();
		session.remove(customer);
		session.getTransaction().commit();
	}

	@Override
	public Customer getCustomerById(int id) {
		// TODO Auto-generated method stub
		session = HibernateUtilFactory.getMySession();
		session.getTransaction().begin();
		Customer c = session.get(Customer.class, id);
		session.getTransaction().commit();
		return c;
	}

	@Override
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		session = HibernateUtilFactory.getMySession();
		session.getTransaction().begin();
		session.merge(customer);
		session.getTransaction().commit();	
	}

	@Override
	public List<Customer> searchCustomer(String searchString) {
		// TODO Auto-generated method stub;
		session.getTransaction().begin();
		Query query = session.createQuery("from Customer c where firstName like concat('%',:searchString,'%') or lastName like concat('%',:searchString,'%') or address like concat('%',:searchString,'%') or customerType like concat('%',:searchString,'%')");
		query.setParameter("searchString", searchString);
		session.getTransaction().commit();
		@SuppressWarnings("unchecked")
		List <Customer> list = query.getResultList();
		return list;
	}
}
