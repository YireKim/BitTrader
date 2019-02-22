package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import domain.CategoriesDTO;
import enums.CategoriesSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class CategoriesDAOImpl implements CategoriesDAO {

	private static CategoriesDAOImpl instance = new CategoriesDAOImpl();
	
	public CategoriesDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createCategory(CategoriesDTO cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<CategoriesDTO> selectListOfCategories(Proxy pxy) {
		List<CategoriesDTO> list = new ArrayList<>();
		try {
			Pagination pagination = ((PageProxy)pxy).getPage();
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CategoriesSQL.LIST.toString());

			String startRow = String.valueOf(pagination.getStartRow());
			String endRow = String.valueOf(pagination.getEndRow());
			
			ps.setString(1, endRow);
			ps.setString(2, startRow);

			ResultSet rs = ps.executeQuery();

			CategoriesDTO cat = null;
			while (rs.next()) {
				cat = new CategoriesDTO();
				cat.setCategoryId(rs.getString("CATEGORY_ID"));
				cat.setNoteDescription(rs.getString("NOTE_DESCRIPTION"));
				cat.setCategoryName(rs.getString("CATEGORY_NAMN"));
				list.add(cat);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CategoriesDTO> selectSomeOfCategories(CategoriesDTO cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CategoriesDTO selectACategory(CategoriesDTO cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Object> selectACategoryPic(CategoriesDTO cat) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int countCategory(Proxy pxy) {
		int count = 0;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CategoriesSQL.ROW_COUNT.toString());

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existCategory(CategoriesDTO cat) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateCategory(CategoriesDTO cat) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Map<String, Object> fileUpload(Proxy pxy) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCategory(CategoriesDTO cat) {
		// TODO Auto-generated method stub
		
	}

	public static CategoriesDAOImpl getInstance() {
		return instance;
	}

}
