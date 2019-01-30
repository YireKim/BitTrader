package service;

import java.util.List;

import dao.OrdersDAOImpl;
import domain.OrdersDTO;

public class OrdersServiceImpl implements OrdersService{
	
	private static OrdersServiceImpl instance = new OrdersServiceImpl();
	
	
	private OrdersServiceImpl() {
		dao = OrdersDAOImpl.getInstance();
	}
	

	public static OrdersServiceImpl getInstance() {return instance;}
	OrdersDAOImpl dao;



	@Override
	public void addOrder(OrdersDTO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrdersDTO> retrieveListOfCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersDTO> retrieveOneOfCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersDTO retrieveAnCustomer(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countOrder() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean existOrder(String searchWord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyOrder(OrdersDTO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeOrder(OrdersDTO order) {
		// TODO Auto-generated method stub
		
	}

	

}
