package service;

import java.util.List;

import dao.ShippersDAOImpl;

public class ShippersServiceImpl implements ShippersService {
	
	private static ShippersServiceImpl instance = new ShippersServiceImpl();
	
	private ShippersServiceImpl() {
		dao = ShippersDAOImpl.getInstance();
		
	}

	
	public static ShippersServiceImpl getInstance() {return instance;}
	
	ShippersDAOImpl dao;
	
	@Override
	public void addShipper(ShippersService shipper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ShippersService> retrieveListOfShippers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShippersService> retrieveOneOfShippers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShippersService retrieveAShipper(String searchWord) {
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
	public void modifyShipper(ShippersService shipper) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeShipper(ShippersService shipper) {
		// TODO Auto-generated method stub
		
	}

}
