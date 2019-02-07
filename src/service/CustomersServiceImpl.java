package service;

import java.util.List;

import dao.CustomersDAOImpl;
import domain.CustomersDTO;

public class CustomersServiceImpl implements CustomersService {

	private static CustomersServiceImpl instance = new CustomersServiceImpl();

	private CustomersServiceImpl() {
		dao = CustomersDAOImpl.getInstance();
	}

	public static CustomersServiceImpl getInstance() {return instance;}
	CustomersDAOImpl dao;
	
	@Override
	public void addCustomer(CustomersDTO cust) {
		dao.insertCustomer(cust);
	}

	@Override
	public List<CustomersDTO> retrieveListOfCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CustomersDTO> retrieveOneOfCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomersDTO retrieveAnCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countEmpCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existCustomer(CustomersDTO cust) {
		dao.existCustomer(cust);
		return false;
	}

	@Override
	public void modifyCustomer(CustomersDTO cust) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removceCustomer(CustomersDTO cust) {
		// TODO Auto-generated method stub
		
	}
	
}

