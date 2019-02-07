package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.CustomersDTO;
import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class CustomersDAOImpl implements CustomersDAO{

	private static CustomersDAOImpl instance = new CustomersDAOImpl();
	
	private CustomersDAOImpl() {
		
		}
	
	public static CustomersDAOImpl getInstance() {return instance;}

	@Override
	public void insertCustomer(CustomersDTO cust) {
		try {
		String sql = String.format(EmployeeSQL.CUST_REGISTER.toString(),
				cust.getContactName(),
				cust.getAddress(),
				cust.getCity(),
				cust.getPostalCode(),
				cust.getCountry());	
		
		Connection conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
		
		PreparedStatement prmt = conn.prepareStatement(sql);
		prmt.setString(1, cust.getContactName());
		prmt.setString(2, cust.getAddress());
		prmt.setString(3, cust.getCity());
		prmt.setString(4, cust.getPostalCode());
		prmt.setString(5, cust.getCountry());
		
		int rs = prmt.executeUpdate();
		
		System.out.println((rs == 1) ? "CUST * INSERTED":"INSERT FAIL");
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomersDAO> selectListOfCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomersDAO> selectOneOfCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomersDAO selectAnCustomer(String searchWord) {
		return null;
	}

	@Override
	public int countCustomers() {
		return 0;
	}

	@Override
	public boolean existCustomer(CustomersDTO cust) {
		boolean exist = false;
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(EmployeeSQL.CUST_EXIST.toString());
			
			ps.setString(1, cust.getCustomerId());
			ps.setString(2, cust.getContactName());
			
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
	public void updateCustomer(CustomersDTO cust) {
		
	}

	@Override
	public void deleteCustomer(CustomersDTO cust) {
		
	}
	

}
