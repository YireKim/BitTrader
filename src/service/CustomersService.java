package service;

import java.util.List;
import domain.CustomersDTO;

public interface CustomersService {

	// CREATE
	public void addCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDTO> retrieveListOfCustomers();
	public List<CustomersDTO> retrieveOneOfCustomers(String customerid);
	public CustomersDTO retrieveAnCustomer(String customerid);
	public int countEmpCustomer();
	public boolean existCustomer(CustomersDTO cust);
	
	// UPDATE
	public void modifyCustomer(CustomersDTO cust);
	
	// DELETE
	public void removceCustomer(CustomersDTO cust);
	
}
