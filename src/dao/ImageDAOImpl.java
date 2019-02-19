package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import domain.ImageDTO;
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
		String sql = "";
		try {
			PreparedStatement ps = DatabaseFactory
					.createDatabase(Vendor.ORACLE)
					.getConnection()
					.prepareStatement("");
			
			ps.executeQuery();
			
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
	public void updateImage(ImageDTO img) {
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
	public void deleteImage(ImageDTO img) {
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
		// TODO Auto-generated method stub
		return null;
	}
}
