package service;

import java.util.List;
import java.util.Map;

import domain.ProductsDTO;
import proxy.Proxy;

public interface ProductsService {

	// CREATE
	public void addProduct(ProductsDTO prod);

	// READ
	public List<?> retrieveListOfProducts(Proxy pxy);
	public List<ProductsDTO> retrieveSomeOfProducts(ProductsDTO prod);
	public ProductsDTO retrieveAnProduct(ProductsDTO prod);
	public Map<String, Object> retrieveProductPic(ProductsDTO prod);

	public int countProduct(Proxy pxy);
	public boolean existProduct(ProductsDTO prod);

	// UPDATE
	public void modifyProduct(ProductsDTO prod);

	// DELETE
	public void removceProduct(ProductsDTO prod);
}
