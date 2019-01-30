package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class CustomersDAOImpl implements CustomersDAO{

	private static CustomersDAOImpl instance = new CustomersDAOImpl();
	
	private CustomersDAOImpl() {

	}
	
	public static CustomersDAOImpl getInstance() {return instance;}

	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;


	@Override
	public void insertCustomer(CustomersDAO customer) {
		
		
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCustomers() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCustomer(CustomersDAO customer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteCustomer(CustomersDAO customer) {
		// TODO Auto-generated method stub
		
	}
	

}
