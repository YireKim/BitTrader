package service;

import java.util.List;
import java.util.Map;

import dao.ProductsDAOImpl;
import domain.ProductsDTO;
import proxy.Proxy;

public class ProductsServiceImpl implements ProductsService{

	private static ProductsServiceImpl instance = new ProductsServiceImpl();
	
	ProductsDAOImpl dao;

	public ProductsServiceImpl() {
		dao = ProductsDAOImpl.getInstance();
	}
	@Override
	public void addProduct(ProductsDTO prod) {
		dao.createProduct(prod);
	}

	@Override
	public List<ProductsDTO> retrieveListOfProducts(Proxy pxy) {
		return dao.selectListOfProducts(pxy);
	}

	@Override
	public List<ProductsDTO> retrieveSomeOfProducts(ProductsDTO prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsDTO retrieveAnProduct(ProductsDTO prod) {
		return dao.selectAnProduct(prod);
	}

	@Override
	public Map<String, Object> retrieveProductPic(ProductsDTO prod) {
		return dao.selectProductPic(prod);
	}

	@Override
	public int countProduct(Proxy pxy) {
		return dao.countProduct(pxy);
	}

	@Override
	public boolean existProduct(ProductsDTO prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modifyProduct(ProductsDTO prod) {
		dao.updateProduct(prod);
	}

	@Override
	public void removceProduct(ProductsDTO prod) {
		dao.deleteProduct(prod);
	}

	public static ProductsServiceImpl getInstance() {
		return instance;
	}

}
