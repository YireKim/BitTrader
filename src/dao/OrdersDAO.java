package dao;

import java.util.List;

public interface OrdersDAO {

	// CREATE
	public void createOrder(OrdersDAO order);
	
	// READ
	public List<OrdersDAO> selectListOfCustomers();
	public List<OrdersDAO> selectOneOfCustomers(String searchWord);
	public OrdersDAO selectAnCustomer(String searchWord);
	public int countOrder();
	public boolean existOrder(String searchWord);
	
	// UPDATE
	public void updateOrder(OrdersDAO order);
	
	// DELETE
	public void deleteOrder(OrdersDAO order);
}