package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import domain.EmployeesDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class EmployeesDAOImpl implements EmployeesDAO{
	
	private static EmployeesDAOImpl instance = new EmployeesDAOImpl();
	
	private EmployeesDAOImpl() {
	}
	
	public static EmployeesDAOImpl getInstance() {return instance;}

	@Override
	public void insertEmployee(EmployeesDTO emp) {
		try {
			String sql = String.format(EmployeeSQL.EMP_REGISTER.toString(),
					emp.getName(),
					emp.getBirthDate(),
					emp.getPhoto(),
					emp.getNoteInfo(),
					emp.getManagerId());
			
			System.out.println("RUN QUERY : "+sql);
			
			Connection conn = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection();
			
			PreparedStatement prmt = conn.prepareStatement(sql);
			prmt.setString(1, emp.getName());
			prmt.setString(2, emp.getBirthDate());
			prmt.setString(3, emp.getPhoto());
			prmt.setString(4, emp.getNoteInfo());
			prmt.setString(5, emp.getManagerId());
			
			int rs = prmt.executeUpdate();
			
			System.out.println((rs == 1) ? "EMP * INSERTED":"INSERT FAIL");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public List<EmployeesDTO> selectListOfEmployees() {
		List<EmployeesDTO> list = new ArrayList<>();
		
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<EmployeesDTO> selectOneOfEmployees(String employeeId) {
		List<EmployeesDTO> list = new ArrayList<>();
		
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public EmployeesDTO selectAnEmployee(String employeeId) {
		EmployeesDTO emp = new EmployeesDTO();
		
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return emp;
	}

	@Override
	public int countEmployees() {
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			
			ps.setString(1, "");
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public boolean existEmployee(EmployeesDTO emp) {
		boolean exist = false;
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(EmployeeSQL.EMP_EXIST.toString());
			
			ps.setString(1, emp.getEmployeeId());
			ps.setString(2, emp.getName());
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				exist = true;
				}
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		return exist;
	}

	@Override
	public void updateEmployee(EmployeesDTO emp) {
		
		String sql = "";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteEmployee(EmployeesDTO emp) {
		String sql = "";
		PreparedStatement ps;
		ResultSet rs;
		try {
			ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

}
