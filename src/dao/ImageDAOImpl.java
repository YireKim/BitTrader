package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.CustomersDTO;
import domain.ImageDTO;
import enums.ImageSQL;
import enums.Vendor;
import factory.DatabaseFactory;
import proxy.Proxy;

public class ImageDAOImpl implements ImageDAO{
	
	private static ImageDAOImpl instance = new ImageDAOImpl();
	
	public ImageDAOImpl() {
	}
	
	public static ImageDAOImpl getInstance() {
		return instance;
	}
	
	@Override
	public void insertImage(ImageDTO img) {
		CustomersDTO cust = new CustomersDTO();
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ImageSQL.UPLOAD_IMAGE.toString());
			ps.setString(1, img.getImgName());
			ps.setString(2, img.getImgExtention());
			ps.setString(3, img.getImgOwner());
			ps.executeUpdate();
			
			System.out.println("Imge Insert SQL ::: "+img.getImgSeq()+"  "+img.getImgOwner()+"  "+img.getImgName());
			System.out.println("@@@ IMG insert DAO :: "+img);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ImageDTO> selectListOfImage(Proxy pxy) {
		List<ImageDTO> list = new ArrayList<>();
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ImageSQL.SELECT_IMG.toString());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public List<ImageDTO> selectSomeOfImage(ImageDTO img) {
		List<ImageDTO> list = new ArrayList<>();
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement("");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ImageDTO selectAnImage(ImageDTO img) {
		ImageDTO temp = null;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ImageSQL.SELECT_IMG.toString());
			
			ps.setString(1, img.getImgOwner());
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				temp = new ImageDTO();
				temp.setImgSeq(rs.getString("IMAGE_ID"));
				temp.setImgName(rs.getString("IMAGE_NAME"));
				temp.setImgExtention(rs.getString("IMAGE_EXTENTION"));
				temp.setImgOwner(rs.getString("IMAGE_OWNER"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return temp;
	}

	@Override
	public int countImage(Proxy pxy) {
		int count = 0;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement("");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return count;
	}

	@Override
	public boolean existImageSeq(ImageDTO img) {
		boolean exist = false;
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement("");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return exist;
	}

	@Override
	public void updateImage(Proxy pxy) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement("");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void deleteImage(Proxy pxy) {
		try {
			String sql = "";
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement("");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public String recentImageSeq() {
		ImageDTO img = new ImageDTO();
		String imgSeq = null;
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement(ImageSQL.LAST_IMG_SEQ.toString());
					
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				img.setImgSeq(rs.getString("IMG_SEQ"));
				imgSeq = img.getImgSeq();
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return imgSeq;
		
	}
}
