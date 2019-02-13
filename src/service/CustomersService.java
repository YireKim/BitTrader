package service;

import java.util.List;
import domain.CustomersDTO;
import proxy.Pagination;
import proxy.Proxy;

public interface CustomersService {

	// CREATE
	public void addCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDTO> retrieveListOfCustomers(Proxy pxy);
	public List<CustomersDTO> retrieveOneOfCustomers(CustomersDTO cust);
	public CustomersDTO retrieveAnCustomer(CustomersDTO cust);
	public int countEmpCustomer(Proxy pxy);
	public boolean existCustomer(CustomersDTO cust);
	
	// UPDATE
	public void modifyCustomer(CustomersDTO cust);
	
	// DELETE
	public void removceCustomer(CustomersDTO cust);
	
}
