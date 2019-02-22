package service;

import java.util.List;
import java.util.Map;

import dao.CategoriesDAOImpl;
import domain.CategoriesDTO;
import proxy.Proxy;

public class CategoriesServiceImpl implements CategoriesService {

	private static CategoriesServiceImpl instance = new CategoriesServiceImpl();
	
	CategoriesDAOImpl dao;
	
	public CategoriesServiceImpl() {
		dao = CategoriesDAOImpl.getInstance();
	}
	
	@Override
	public void addCategory(CategoriesDTO cat) {
		dao.createCategory(cat);
	}

	@Override
	public List<?> retrieveListOfCategories(Proxy pxy) {
		return dao.selectListOfCategories(pxy);
	}

	@Override
	public List<CategoriesDTO> retrieveSomeOfCategories(CategoriesDTO cat) {
		return dao.selectSomeOfCategories(cat);
	}

	@Override
	public CategoriesDTO retrieveACategory(CategoriesDTO cat) {
		return dao.selectACategory(cat);
	}

	@Override
	public Map<String, Object> retrieveACategoryPic(CategoriesDTO cat) {
		return dao.selectACategoryPic(cat);
	}

	@Override
	public int countCategory(Proxy pxy) {
		return dao.countCategory(pxy);
	}

	@Override
	public boolean existCategory(CategoriesDTO cat) {
		return dao.existCategory(cat);
	}

	@Override
	public void modifyCategory(CategoriesDTO cat) {
		dao.updateCategory(cat);
	}

	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		return dao.fileUpload(pxy);
	}

	@Override
	public void removceCategory(CategoriesDTO cat) {
		dao.deleteCategory(cat);
		
	}

	public static CategoriesServiceImpl getInstance() {
		return instance;
	}

}
