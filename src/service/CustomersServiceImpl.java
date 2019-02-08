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
	public List<CustomersDTO> retrieveOneOfCustomers(CustomersDTO cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomersDTO retrieveAnCustomer(CustomersDTO cust) {
		dao.selectAnCustomer(cust);
		return null;
	}

	@Override
	public int countEmpCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existCustomer(CustomersDTO cust) {
		dao.existCustomerId(cust);
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

