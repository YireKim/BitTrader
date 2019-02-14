package service;

import java.util.List;
import java.util.Map;

import dao.CustomersDAOImpl;
import domain.CustomersDTO;
import proxy.Proxy;

public class CustomersServiceImpl implements CustomersService {

	private static CustomersServiceImpl instance = new CustomersServiceImpl();

	private CustomersServiceImpl() {
		dao = CustomersDAOImpl.getInstance();
	}

	public static CustomersServiceImpl getInstance() {
		return instance;
	}

	CustomersDAOImpl dao;

	@Override
	public void addCustomer(CustomersDTO cust) {
		dao.insertCustomer(cust);
	}

	@Override
	public List<CustomersDTO> retrieveListOfCustomers(Proxy pxy) {
		return dao.selectListOfCustomers(pxy);
	}

	@Override
	public List<CustomersDTO> retrieveOneOfCustomers(CustomersDTO cust) {
		return dao.selectOneOfCustomers(cust);
	}

	@Override
	public CustomersDTO retrieveAnCustomer(CustomersDTO cust) {
		return dao.selectAnCustomer(cust);
	}

	@Override
	public int countEmpCustomer(Proxy pxy) {
		return dao.countCustomers(pxy);
	}

	@Override
	public boolean existCustomer(CustomersDTO cust) {
		return dao.existCustomerId(cust);
	}

	@Override
	public void modifyCustomer(CustomersDTO cust) {
		dao.updateCustomer(cust);
	}

	@Override
	public void removceCustomer(CustomersDTO cust) {
		dao.deleteCustomer(cust);
	}

	@Override
	public Map<String, Object> retrievePhoneNum(Proxy pxy) {
		return dao.selectPhoneNum(pxy);
	}

}
