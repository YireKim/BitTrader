package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.ImageDTO;
import domain.ProductsDTO;
import enums.CustomerSQL;
import enums.ProductsSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;

public class ProductsDAOImpl implements ProductsDAO{

	private static ProductsDAOImpl instance = new ProductsDAOImpl();
	
	public ProductsDAOImpl() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public void createProduct(ProductsDTO prod) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ProductsDTO> selectListOfProducts(Proxy pxy) {
		List<ProductsDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ProductsSQL.LIST.toString());

			System.out.println("===== PPPP : IN >> Start "+page.getStartRow()+"   End "+page.getEndRow());
			
			String startRow = String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			
			ps.setString(1, endRow);
			ps.setString(2, startRow);

			ResultSet rs = ps.executeQuery();

			ProductsDTO prod = null;
			while (rs.next()) {
				prod = new ProductsDTO();
				prod.setNo(rs.getString("NO"));
				prod.setProductId(rs.getString("SEQ_PRODUCT_ID"));
				prod.setProductName(rs.getString("PRODUCT_NAME"));
				prod.setSupplierId(rs.getString("SUPPLIER_ID"));
				prod.setCategoryId(rs.getString("CATEGORY_ID"));
				prod.setUnit(rs.getString("UNIT"));
				prod.setPrice(rs.getString("PRICE"));
				prod.setPhoto(rs.getString("PHOTO"));
				list.add(prod);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ProductsDTO> selectSomeOfProducts(ProductsDTO prod) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ProductsDTO selectAnProduct(ProductsDTO prod) {
		ProductsDTO temp = null;
		PreparedStatement ps = null;
		try {
				ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
						.prepareStatement(ProductsSQL.CHK_PRODID.toString());
				ps.setString(1, prod.getProductId());

				ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp = new ProductsDTO();
				temp.setProductId(rs.getString("SEQ_PRODUCT_ID"));
				temp.setProductName(rs.getString("PRODUCT_NAME"));
				temp.setSupplierId(rs.getString("SUPPLIER_ID"));
				temp.setCategoryId(rs.getString("CATEGORY_ID"));
				temp.setUnit(rs.getString("UNIT"));
				temp.setPrice(rs.getString("PRICE"));
				temp.setPhoto(rs.getString("PHOTO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public Map<String, Object> selectProductPic(ProductsDTO prod) {
		Map<String, Object> map = new HashMap<String, Object>();
		ImageDTO img = new ImageDTO();
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.SELECT_PIC.toString());
			
			ps.setString(1, prod.getProductId());
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()) {
				img.setImgSeq(rs.getString("IMAGE_ID"));
				img.setImgName(rs.getString("IMAGE_NAME"));
				img.setImgExtention(rs.getString("IMAGE_EXTENTION"));
				img.setImgOwner(rs.getString("IMAGE_OWNER"));
				map.put("imagekey", img);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	@Override
	public int countProduct(Proxy pxy) {
		int count = 0;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ProductsSQL.ROW_COUNT.toString());

			ResultSet rs = ps.executeQuery();
			
			if (rs.next()) {
				count = rs.getInt("TOTALCOUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existProduct(ProductsDTO prod) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void updateProduct(ProductsDTO prod) {
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ProductsSQL.UPDATE.toString());

			ps.setString(1, prod.getUnit());
			ps.setString(2, prod.getPrice());
			ps.setString(3, prod.getProductId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteProduct(ProductsDTO prod) {
		// TODO Auto-generated method stub
		
	}

	public static ProductsDAOImpl getInstance() {
		return instance;
	}

}
