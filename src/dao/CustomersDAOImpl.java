package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import domain.CustomersDTO;
import enums.CustomerSQL;
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
		PreparedStatement ps = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection().prepareStatement(CustomerSQL.SIGNUP.toString());
		
		ps.setString(1, cust.getContactName());
		ps.setString(2, cust.getAddress());
		ps.setString(3, cust.getCity());
		ps.setString(4, cust.getPostalCode());
		ps.setString(5, cust.getCountry());
		
		ps.executeQuery();
		
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
	public List<CustomersDAO> selectOneOfCustomers(CustomersDTO cust) {
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
			ps.setString(2, cust.getContactName());

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp = new CustomersDTO();
				temp.setCustomerId(rs.getString("CUSTOMER_ID"));
				temp.setContactName(rs.getString("CONTACT_NAME"));
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setCity(rs.getString("CITY"));
				temp.setPostalCode(rs.getString("POSTAL_CODE"));
				temp.setCountry(rs.getString("COUNTRY"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return temp;
	}

	@Override
	public int countCustomers() {
		return 0;
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
