package service;

import java.util.List;

import dao.EmployeesDAOImpl;
import domain.EmployeesDTO;

public class EmployeesServiceImpl implements EmployeessService {

	private static EmployeesServiceImpl instance = new EmployeesServiceImpl();
	
	private EmployeesServiceImpl() {
		dao = EmployeesDAOImpl.getInstance();
	}
	
	public static EmployeesServiceImpl getInstance() {return instance;}
	EmployeesDAOImpl dao;
	
	@Override
	public void addEmployee(EmployeesDTO emp) {
		dao.insertEmployee(emp);
	}

	@Override
	public List<EmployeesDTO> retrieveListOfEmployees() {
		return dao.selectListOfEmployees();
	}

	@Override
	public List<EmployeesDTO> retrieveOneOfEmployees(String employeeId) {
		// TODO Auto-generated method stub
		return dao.selectOneOfEmployees(employeeId);
	}

	@Override
	public EmployeesDTO retrieveAnEmployee(String employeeId) {
		return dao.selectAnEmployee(employeeId);
	}

	@Override
	public int countEmployees() {
		return dao.countEmployees();
	}

	@Override
	public boolean existEmployee(EmployeesDTO emp) {
		return dao.existEmployee(emp);
	}

	@Override
	public void modifyEmployee(EmployeesDTO emp) {
		dao.updateEmployee(emp);
	}

	@Override
	public void removceEmployee(EmployeesDTO emp) {
		dao.deleteEmployee(emp);
	}




}
