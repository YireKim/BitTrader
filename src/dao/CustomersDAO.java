package dao;

import java.util.List;

import domain.CustomersDTO;
import proxy.Proxy;

public interface CustomersDAO {

	// CREATE
	public void insertCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDTO> selectListOfCustomers(Proxy pxy);
	public List<CustomersDTO> selectOneOfCustomers(CustomersDTO cust);
	public CustomersDTO selectAnCustomer(CustomersDTO cust);
	public int countCustomers();
	public boolean existCustomerId(CustomersDTO cust);
	
	// UPDATE
	public void updateCustomer(CustomersDTO cust);
	
	// DELETE
	public void deleteCustomer(CustomersDTO cust);


	
}
