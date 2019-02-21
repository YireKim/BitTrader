package dao;

import java.util.List;
import java.util.Map;

import domain.CustomersDTO;
import proxy.Proxy;

public interface CustomersDAO {

	// CREATE
	public void insertCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDTO> selectListOfCustomers(Proxy pxy);
	public List<CustomersDTO> selectSomeOfCustomers(CustomersDTO cust);
	public CustomersDTO selectAnCustomer(CustomersDTO cust);
	public Map<String, Object> selectProfilePic(CustomersDTO cust);
	public int countCustomers(Proxy pxy);
	public boolean existCustomerId(CustomersDTO cust);
	
	// UPDATE
	public void updateCustomer(CustomersDTO cust);
	public Map<String, Object> selectProfile(Proxy pxy);
	
	// DELETE
	public void deleteCustomer(CustomersDTO cust);


	
}
