package service;

import java.util.List;

import dao.CustomersDAOImpl;
import domain.CustomersDTO;
import proxy.Pagination;

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
	public List<CustomersDTO> retrieveListOfCustomers(Pagination page) {
		return dao.selectListOfCustomers(page);
	}

	@Override
	public List<CustomersDTO> retrieveOneOfCustomers(CustomersDTO cust) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CustomersDTO retrieveAnCustomer(CustomersDTO cust) {
		return dao.selectAnCustomer(cust);
	}

	@Override
	public int countEmpCustomer() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existCustomer(CustomersDTO cust) {
		return dao.existCustomerId(cust);
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

