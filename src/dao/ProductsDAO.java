package dao;

import java.util.List;
import java.util.Map;

import domain.CustomersDTO;
import domain.ProductsDTO;
import proxy.Proxy;

public interface ProductsDAO {

	// CREATE
	public void createProduct(ProductsDTO prod);

	// READ
	public List<ProductsDTO> selectListOfProducts(Proxy pxy);
	public List<ProductsDTO> selectSomeOfProducts(ProductsDTO prod);
	public ProductsDTO selectAnProduct(ProductsDTO prod);
	public Map<String, Object> selectProductPic(ProductsDTO prod);

	public int countProduct(Proxy pxy);
	public boolean existProduct(ProductsDTO prod);

	// UPDATE
	public void updateProduct(ProductsDTO prod);

	// DELETE
	public void deleteProduct(ProductsDTO prod);
}
