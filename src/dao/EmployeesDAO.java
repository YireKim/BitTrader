package dao;

import java.util.List;
import domain.EmployeesDTO;

public interface EmployeesDAO {

	// CREATE
	public void insertEmployee(EmployeesDTO emp);
	
	// READ
	public List<EmployeesDTO> selectListOfEmployees();
	public List<EmployeesDTO> selectOneOfEmployees(String employeeId);
	public EmployeesDTO selectAnEmployee(String employeeId);
	public int countEmployees();
	public boolean existEmployee(EmployeesDTO emp);
	
	// UPDATE
	public void updateEmployee(EmployeesDTO emp);
	
	// DELETE
	public void deleteEmployee(EmployeesDTO emp);
	
}
