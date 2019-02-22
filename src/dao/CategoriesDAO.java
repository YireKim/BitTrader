package dao;

import java.util.List;
import java.util.Map;

import domain.CategoriesDTO;
import proxy.Proxy;

public interface CategoriesDAO {
	// CREATE
			public void createCategory(CategoriesDTO cat);
			
			// READ
			public List<CategoriesDTO> selectListOfCategories(Proxy pxy);
			public List<CategoriesDTO> selectSomeOfCategories(CategoriesDTO cat);
			public CategoriesDTO selectACategory(CategoriesDTO cat);
			public Map<String, Object> selectACategoryPic(CategoriesDTO cat);
			public int countCategory(Proxy pxy);
			public boolean existCategory(CategoriesDTO cat);
			
			// UPDATE
			public void updateCategory(CategoriesDTO cat);
			public Map<String,Object> fileUpload(Proxy pxy);
			
			// DELETE
			public void deleteCategory(CategoriesDTO cat);
			
}
