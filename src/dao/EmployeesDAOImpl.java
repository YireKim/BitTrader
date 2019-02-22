package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.EmployeesDTO;
import domain.ImageDTO;
import enums.CustomerSQL;
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
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(EmployeeSQL.REGISTER.toString());
			
			ps.setString(1, emp.getName());
			ps.setString(2, emp.getBirthDate());
			ps.setString(3, emp.getNoteInfo());
			ps.setString(4, emp.getManagerId());
			ps.executeUpdate();
			
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
	public List<EmployeesDTO> selectOneOfEmployees(EmployeesDTO emp) {
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
	public EmployeesDTO selectAnEmployee(EmployeesDTO emp) {
		EmployeesDTO temp = null;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(EmployeeSQL.ACCESS.toString());

			ps.setString(1, emp.getEmployeeId());
			ps.setString(2, emp.getName());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp = new EmployeesDTO();
				temp.setEmployeeId(rs.getString("EMPLOYEE_ID"));
				temp.setName(rs.getString("EMPLOYEE_NAME"));
				temp.setBirthDate(rs.getString("BIRTHDATE"));
				temp.setPhoto(rs.getString("PHOTO"));
				temp.setNoteInfo(rs.getString("NOTE_INFO"));
				temp.setManagerId(rs.getString("MANAGER_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
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
			.prepareStatement(EmployeeSQL.ACCESS.toString());
			
			ps.setString(1, "");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
	
		
		try {
			String sql = "";

			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(sql);
			
			ps.setString(1, "");
			ps.executeQuery();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public Map<String, Object> selectAnEmployeePic(EmployeesDTO emp) {
		Map<String, Object> map = new HashMap<String, Object>();
		ImageDTO img = new ImageDTO();
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.SELECT_PIC.toString());
			
			ps.setString(1, emp.getEmployeeId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				img.setImgSeq(rs.getString("IMAGE_ID"));
				img.setImgName(rs.getString("IMAGE_NAME"));
				img.setImgExtention(rs.getString("IMAGE_EXTENTION"));
				img.setImgOwner(rs.getString("IMAGE_OWNER"));
				map.put("imagekey", img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

}
