package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class ShippersDAOImpl implements ShippersDAO{
	
	private static ShippersDAOImpl instance = new ShippersDAOImpl();
	
	private ShippersDAOImpl() {
	}

	
	public static ShippersDAOImpl getInstance() {return instance;}
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	

	@Override
	public void createShipper(ShippersDAO shipper) {
		
		
	}

	@Override
	public List<ShippersDAO> selectListOfShippers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShippersDAO> selectOneOfShippers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShippersDAO selectAShipper(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countShipper() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existShipper(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateShipper(ShippersDAO shipper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteShipper(ShippersDAO shipper) {
		// TODO Auto-generated method stub
		
	}

}
