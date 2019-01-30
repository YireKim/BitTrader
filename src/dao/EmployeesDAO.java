package dao;

import java.util.List;
import domain.EmployeesDTO;

public interface EmployeesDAO {

	// CREATE
	public void insertEmployee(EmployeesDTO emp);
	
	// READ
	public List<EmployeesDTO> selectListOfEmployees();
	public List<EmployeesDTO> selectOneOfEmployees(String searchWord);
	public EmployeesDTO selectAnEmployee(String searchWord);
	public int countEmployees();
	public boolean existEmployee(String searchWord);
	
	// UPDATE
	public void updateEmployee(EmployeesDTO emp);
	
	// DELETE
	public void deleteEmployee(EmployeesDTO emp);
	
}
