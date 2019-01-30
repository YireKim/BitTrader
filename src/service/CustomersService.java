package service;

import java.util.List;
import domain.CustomersDTO;

public interface CustomersService {

	// CREATE
	public void addCustomer(CustomersDTO customer);
	
	// READ
	public List<CustomersDTO> retrieveListOfCustomers();
	public List<CustomersDTO> retrieveOneOfCustomers(String searchWord);
	public CustomersDTO retrieveAnCustomer(String searchWord);
	public int countEmpCustomer();
	public boolean existCustomer(String searchWord);
	
	// UPDATE
	public void modifyCustomer(CustomersDTO customer);
	
	// DELETE
	public void removceCustomer(CustomersDTO customer);
	
}
