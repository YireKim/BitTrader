package dao;

import java.util.List;

import domain.CustomersDTO;

public interface CustomersDAO {

	// CREATE
	public void insertCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDAO> selectListOfCustomers();
	public List<CustomersDAO> selectOneOfCustomers(CustomersDTO cust);
	public CustomersDTO selectAnCustomer(CustomersDTO cust);
	public int countCustomers();
	public boolean existCustomerId(CustomersDTO cust);
	
	// UPDATE
	public void updateCustomer(CustomersDTO cust);
	
	// DELETE
	public void deleteCustomer(CustomersDTO cust);
	
}
