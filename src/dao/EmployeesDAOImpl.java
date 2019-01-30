package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import domain.EmployeesDTO;

public class EmployeesDAOImpl implements EmployeesDAO{
	
	private static EmployeesDAOImpl instance = new EmployeesDAOImpl();
	
	private EmployeesDAOImpl() {
	}
	
	public static EmployeesDAOImpl getInstance() {return instance;}
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	@Override
	public void insertEmployee(EmployeesDTO emp) {
		try {
			Class.forName("");
			
			conn = DriverManager.getConnection("", "", "");
			stmt = conn.createStatement();
			rs = stmt.executeQuery("");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public List<EmployeesDTO> selectListOfEmployees() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EmployeesDTO> selectOneOfEmployees(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EmployeesDTO selectAnEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmployees() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existEmployee(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateEmployee(EmployeesDTO emp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteEmployee(EmployeesDTO emp) {
		// TODO Auto-generated method stub
		
	}


}
