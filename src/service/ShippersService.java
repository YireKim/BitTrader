package service;

import java.util.List;

public interface ShippersService {

	// CREATE
	public void addShipper(ShippersService shipper);
	
	// READ
	public List<ShippersService> retrieveListOfShippers();
	public List<ShippersService> retrieveOneOfShippers(String searchWord);
	public ShippersService retrieveAShipper(String searchWord);
	public int countShipper();
	public boolean existShipper(String searchWord);
	
	// UPDATE
	public void modifyShipper(ShippersService shipper);
	
	// DELETE
	public void removeShipper(ShippersService shipper);
	
}