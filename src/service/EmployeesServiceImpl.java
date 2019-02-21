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
	public List<EmployeesDTO> retrieveOneOfEmployees(EmployeesDTO emp) {
		// TODO Auto-generated method stub
		return dao.selectOneOfEmployees(emp);
	}

	@Override
	public EmployeesDTO retrieveAnEmployee(EmployeesDTO emp) {
		return dao.selectAnEmployee(emp);
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

	public EmployeesDTO retrieveAnEmployeePic(EmployeesDTO emp) {
		return dao.selectAnEmployeePic(emp);
	}




}
