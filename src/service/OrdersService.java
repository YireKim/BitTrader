package service;

import java.util.List;

import domain.OrdersDTO;

public interface OrdersService {

	// CREATE
	public void addOrder(OrdersDTO order);
	
	// READ
	public List<OrdersDTO> retrieveListOfCustomers();
	public List<OrdersDTO> retrieveOneOfCustomers(String searchWord);
	public OrdersDTO retrieveAnCustomer(String searchWord);
	public int countOrder();
	public boolean existOrder(String searchWord);
	
	// UPDATE
	public void modifyOrder(OrdersDTO order);
	
	// DELETE
	public void removeOrder(OrdersDTO order);
}
