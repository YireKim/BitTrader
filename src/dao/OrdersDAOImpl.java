package dao;

import java.sql.Connection;
import java.util.List;

public class OrdersDAOImpl implements OrdersDAO {
	
	private static OrdersDAOImpl instance = new OrdersDAOImpl();
	
	private OrdersDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	public static OrdersDAOImpl getInstance() {return instance;}

	private Connection conn = null;

	@Override
	public void createOrder(OrdersDAO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<OrdersDAO> selectListOfCustomers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<OrdersDAO> selectOneOfCustomers(String searchWord) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdersDAO selectAnCustomer(String searchWord) {
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
	public void updateOrder(OrdersDAO order) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteOrder(OrdersDAO order) {
		// TODO Auto-generated method stub
		
	}

}
