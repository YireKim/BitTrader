package dao;

import java.util.List;

public interface ShippersDAO {

	// CREATE
	public void createShipper(ShippersDAO shipper);
	
	// READ
	public List<ShippersDAO> selectListOfShippers();
	public List<ShippersDAO> selectOneOfShippers(String searchWord);
	public ShippersDAO selectAShipper(String searchWord);
	public int countShipper();
	public boolean existShipper(String searchWord);
	
	// UPDATE
	public void updateShipper(ShippersDAO shipper);
	
	// DELETE
	public void deleteShipper(ShippersDAO shipper);
	
}