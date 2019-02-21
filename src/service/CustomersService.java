package service;

import java.util.List;
import java.util.Map;

import domain.CustomersDTO;
import proxy.Proxy;

public interface CustomersService {

	// CREATE
	public void addCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDTO> retrieveListOfCustomers(Proxy pxy);
	public List<CustomersDTO> retrieveSomeOfCustomers(CustomersDTO cust);
	public CustomersDTO retrieveAnCustomer(CustomersDTO cust);
	public Map<String, Object> retrieveProfilePic(CustomersDTO cust);
	public int countEmpCustomer(Proxy pxy);
	public boolean existCustomer(CustomersDTO cust);
	
	// UPDATE
	public void modifyCustomer(CustomersDTO cust);
	
	// DELETE
	public void removceCustomer(CustomersDTO cust);
	
	public Map<String,Object> fileUpload(Proxy pxy);



}