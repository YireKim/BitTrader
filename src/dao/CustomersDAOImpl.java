package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CustomersDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Pagination;

public class CustomersDAOImpl implements CustomersDAO{

	private static CustomersDAOImpl instance = new CustomersDAOImpl();
	
	private CustomersDAOImpl() {
		
		}
	
	public static CustomersDAOImpl getInstance() {return instance;}

	@Override
	public void insertCustomer(CustomersDTO cust) {
		try {
		PreparedStatement ps = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection()
				.prepareStatement(CustomerSQL.SIGNUP.toString());
		
		ps.setString(1, cust.getContactName());
		ps.setString(2, cust.getAddress());
		ps.setString(3, cust.getCity());
		ps.setString(4, cust.getPostalCode());
		ps.setString(5, cust.getCountry());
		ps.setString(6, cust.getSsn());
		ps.setString(7, cust.getPhone());
		ps.setString(8, cust.getPassword());
		
		ps.executeQuery();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomersDTO> selectListOfCustomers(Pagination page) {
		List<CustomersDTO> list = new ArrayList<>(); 
		
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.LIST.toString());
			
			ps.setInt(1, page.getStartPage());
			ps.setInt(2, page.getEndPage());
			
			ResultSet rs = ps.executeQuery();
			
			CustomersDTO cust = null;
			while(rs.next()) {
				cust = new CustomersDTO();
				cust.setNo(rs.getString("NO"));
				cust.setCustomerId(rs.getString("CUSTOMER_ID"));
				cust.setContactName(rs.getString("CONTACT_NAME"));
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setCity(rs.getString("CITY"));
				cust.setPostalCode(rs.getString("POSTAL_CODE"));
				cust.setCountry(rs.getString("COUNTRY"));
				cust.setSsn(rs.getString("SSN"));
				cust.setPhone(rs.getString("PHONE"));
				cust.setPassword(rs.getString("PASSWORD"));
				
				list.add(cust);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public List<CustomersDTO> selectOneOfCustomers(CustomersDTO cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomersDTO selectAnCustomer(CustomersDTO cust) {
		CustomersDTO temp = null;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.SIGNIN.toString());

			ps.setString(1, cust.getCustomerId());
			ps.setString(2, cust.getPassword());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp = new CustomersDTO();
				temp.setCustomerId(rs.getString("CUSTOMER_ID"));
				temp.setContactName(rs.getString("CONTACT_NAME"));
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setCity(rs.getString("CITY"));
				temp.setPostalCode(rs.getString("POSTAL_CODE"));
				temp.setCountry(rs.getString("COUNTRY"));
				temp.setSsn(rs.getString("SSN"));
				temp.setPhone(rs.getString("PHONE"));
				temp.setPassword(rs.getString("PASSWORD"));
				temp.setPhoto(rs.getString("PHOTO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	@Override
	public int countCustomers() {
		int count = 0;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.COUNT.toString());
			
			ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existCustomerId(CustomersDTO cust) {
		boolean exist = false;
		try {
			PreparedStatement ps = DatabaseFactory
			.createDatabase(Vendor.ORACLE)
			.getConnection()
			.prepareStatement(CustomerSQL.SIGNIN.toString());
			
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
