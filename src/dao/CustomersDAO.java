package dao;

import java.util.List;
import domain.EmployeesDTO;

public interface CustomersDAO {

	// CREATE
	public void insertCustomer(CustomersDAO customer);
	
	// READ
	public List<CustomersDAO> selectListOfCustomers();
	public List<CustomersDAO> selectOneOfCustomers(String searchWord);
	public CustomersDAO selectAnCustomer(String searchWord);
	public int countCustomers();
	public boolean existCustomer(String searchWord);
	
	// UPDATE
	public void updateCustomer(CustomersDAO customer);
	
	// DELETE
	public void deleteCustomer(CustomersDAO customer);
	
}
