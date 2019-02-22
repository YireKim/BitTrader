package service;

import java.util.List;
import java.util.Map;

import domain.CategoriesDTO;
import proxy.Proxy;

public interface CategoriesService {
		
		// CREATE
		public void addCategory(CategoriesDTO cat);
		
		// READ
		public List<?> retrieveListOfCategories(Proxy pxy);
		public List<CategoriesDTO> retrieveSomeOfCategories(CategoriesDTO cat);
		public CategoriesDTO retrieveACategory(CategoriesDTO cat);
		public Map<String, Object> retrieveACategoryPic(CategoriesDTO cat);
		public int countCategory(Proxy pxy);
		public boolean existCategory(CategoriesDTO cat);
		
		// UPDATE
		public void modifyCategory(CategoriesDTO cat);
		public Map<String,Object> fileUpload(Proxy pxy);
		
		// DELETE
		public void removceCategory(CategoriesDTO cat);
		
}
