package service;

import java.util.List;
import domain.EmployeesDTO;

public interface EmployeessService {

	// CREATE
	public void addEmployee(EmployeesDTO emp);
	
	// READ
	public List<EmployeesDTO> retrieveListOfEmployees();
	public List<EmployeesDTO> retrieveOneOfEmployees(EmployeesDTO emp);
	public EmployeesDTO retrieveAnEmployee(EmployeesDTO emp);
	public int countEmployees();
	public boolean existEmployee(EmployeesDTO emp);
	
	// UPDATE
	public void modifyEmployee(EmployeesDTO emp);
	
	// DELETE
	public void removceEmployee(EmployeesDTO emp);

}
