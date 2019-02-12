package service;

import java.util.List;
import domain.CustomersDTO;
import proxy.Pagination;

public interface CustomersService {

	// CREATE
	public void addCustomer(CustomersDTO cust);
	
	// READ
	public List<CustomersDTO> retrieveListOfCustomers(Pagination page);
	public List<CustomersDTO> retrieveOneOfCustomers(CustomersDTO cust);
	public CustomersDTO retrieveAnCustomer(CustomersDTO cust);
	public int countEmpCustomer();
	public boolean existCustomer(CustomersDTO cust);
	
	// UPDATE
	public void modifyCustomer(CustomersDTO cust);
	
	// DELETE
	public void removceCustomer(CustomersDTO cust);
	
}
