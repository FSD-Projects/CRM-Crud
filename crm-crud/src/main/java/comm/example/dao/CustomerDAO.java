package comm.example.dao;

import java.util.List;

import comm.example.model.Customer;

public interface CustomerDAO {
	public List<Customer> getAllCustomers();
	public void createCustomer(Customer customer);
	public void deleteCustomer(Customer customer);
	public Customer getCustomerById(int id);
	public void updateCustomer(Customer customer);
	public List<Customer> searchCustomer(String searchString);
}
