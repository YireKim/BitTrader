package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import domain.CustomersDTO;
import domain.ImageDTO;
import enums.CustomerSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.ImageProxy;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;

public class CustomersDAOImpl implements CustomersDAO {

	private static CustomersDAOImpl instance = new CustomersDAOImpl();
	Connection conn;
	private CustomersDAOImpl() {
		conn = DatabaseFactory
				.createDatabase(Vendor.ORACLE)
				.getConnection();
	}

	public static CustomersDAOImpl getInstance() {
		return instance;
	}

	@Override
	public void insertCustomer(CustomersDTO cust) {
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.SIGNUP.toString());

			ps.setString(1, cust.getContactName());
			ps.setString(2, cust.getAddress());
			ps.setString(3, cust.getCity());
			ps.setString(4, cust.getPostalCode());
			ps.setString(5, cust.getCountry());
			ps.setString(6, cust.getSsn());
			ps.setString(7, cust.getPhone());
			ps.setString(8, cust.getPassword());

			ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<CustomersDTO> selectListOfCustomers(Proxy pxy) {
		List<CustomersDTO> list = new ArrayList<>();
		try {
			Pagination page = ((PageProxy)pxy).getPage();
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.LIST.toString());

			System.out.println("===== CustomerDAOimpl : IN >> Start "+page.getStartRow()+"   End "+page.getEndRow());
			
			String startRow = String.valueOf(page.getStartRow());
			String endRow = String.valueOf(page.getEndRow());
			
			ps.setString(1, endRow);
			ps.setString(2, startRow);

			ResultSet rs = ps.executeQuery();

			CustomersDTO cust = null;
			while (rs.next()) {
				cust = new CustomersDTO();
				cust.setNo(rs.getString("NO"));
				cust.setCustomerId(rs.getString("CUSTOMER_ID"));
				cust.setContactName(rs.getString("CONTACT_NAME"));
				cust.setAddress(rs.getString("ADDRESS"));
				cust.setCity(rs.getString("CITY"));
				cust.setPostalCode(rs.getString("POSTAL_CODE"));
				cust.setCountry(rs.getString("COUNTRY"));
				cust.setSsn(rs.getString("SSN"));
				cust.setPhone(rs.getString("PHONE"));
				cust.setPassword(rs.getString("PASSWORD"));

				list.add(cust);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<CustomersDTO> selectSomeOfCustomers(CustomersDTO cust) {
		List<CustomersDTO> list = new ArrayList<>();
		
		
				return list;
	}

	@Override
	public CustomersDTO selectAnCustomer(CustomersDTO cust) {
		CustomersDTO temp = null;
		PreparedStatement ps = null;
		try {
			
			if (cust.getPassword() == null) {
				ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
						.prepareStatement(CustomerSQL.CHK_CUSTID.toString());
				ps.setString(1, cust.getCustomerId());
					
			} else {
				ps = DatabaseFactory.createDatabase(Vendor.ORACLE).getConnection()
						.prepareStatement(CustomerSQL.SIGNIN.toString());
				ps.setString(1, cust.getCustomerId());
				ps.setString(2, cust.getPassword());
			}


			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				temp = new CustomersDTO();
				temp.setCustomerId(rs.getString("CUSTOMER_ID"));
				temp.setContactName(rs.getString("CONTACT_NAME"));
				temp.setAddress(rs.getString("ADDRESS"));
				temp.setCity(rs.getString("CITY"));
				temp.setPostalCode(rs.getString("POSTAL_CODE"));
				temp.setCountry(rs.getString("COUNTRY"));
				temp.setSsn(rs.getString("SSN"));
				temp.setPhone(rs.getString("PHONE"));
				temp.setPassword(rs.getString("PASSWORD"));
				temp.setPhoto(rs.getString("PHOTO"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return temp;
	}

	@Override
	public int countCustomers(Proxy pxy) {
		int count = 0;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.ROW_COUNT.toString());

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
	public boolean existCustomerId(CustomersDTO cust) {
		boolean exist = false;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.SIGNIN.toString());

			ps.setString(1, cust.getCustomerId());
			ps.setString(2, cust.getContactName());

			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				exist = true;
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}

		return exist;
	}

	@Override
	public void updateCustomer(CustomersDTO cust) {
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.UPDATE.toString());

			ps.setString(1, cust.getPassword());
			ps.setString(2, cust.getSsn());
			ps.setString(3, cust.getPhone());
			ps.setString(4, cust.getAddress());
			ps.setString(5, cust.getCity());
			ps.setString(6, cust.getCountry());
			ps.setString(7, cust.getCustomerId());
			ps.executeQuery();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteCustomer(CustomersDTO cust) {

	}
	
	@Override
	public Map<String, Object> selectPhoneNum(Proxy pxy) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(CustomerSQL.PHONE_NUM.toString());

			ResultSet rs = ps.executeQuery();
			
			CustomersDTO cust = null;
			
			while (rs.next()) {
				cust = new CustomersDTO();
				String entry = rs.getString("CUSTOMER_ID");
				cust.setCustomerId(rs.getString("CUSTOMER_ID"));
				cust.setContactName(rs.getString("CONTACT_NAME"));
				cust.setPhone(rs.getString("PHONE"));
				map.put(entry, cust);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return map;
	}

	public CustomersDTO selectProfile(Proxy pxy) {
		CustomersDTO cust = new CustomersDTO();
		try {
			String sql = "";
			ImageProxy imgpxy = (ImageProxy) pxy;
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "");
			
			ResultSet rs = ps.executeQuery();
			
			ImageDAOImpl.getInstance().insertImage(((ImageProxy)pxy).getImg());
			
			sql = "UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1, "");
			ps.setString(2, imgpxy.getImg().getImgOwner());
			
			cust.setCustomerId(imgpxy.getImg().getImgOwner());
			cust = selectAnCustomer(cust);
			
			String imgSeq = ImageDAOImpl.getInstance().recentImageSeq();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return cust;
		
	}

	public void updateImage(Proxy pxy) {
		// TODO Auto-generated method stub
		
	}
}