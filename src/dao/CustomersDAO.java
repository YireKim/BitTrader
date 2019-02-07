package dao;

import java.util.List;

import domain.CustomersDTO;

public interface CustomersDAO {

	// CREATE
	public void insertCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDAO> selectListOfCustomers();
	public List<CustomersDAO> selectOneOfCustomers(String searchWord);
	public CustomersDAO selectAnCustomer(String searchWord);
	public int countCustomers();
	public boolean existCustomer(CustomersDTO cust);
	
	// UPDATE
	public void updateCustomer(CustomersDTO cust);
	
	// DELETE
	public void deleteCustomer(CustomersDTO cust);
	
}
