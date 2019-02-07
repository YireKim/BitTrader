package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import enums.Props;

public class ConnTest2 {

	public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			try {
				Class.forName(Props.ORA_DRIVER.getValue());
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:59162:xe",
						"Eli",
						"2213");
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT COUNT(*) FROM EMPLOYEES");
				
				String sql = "";
				
				while(rs.next()){
					sql = rs.getString("count(*)");
				}
				System.out.println("EMP : "+sql);
				
			} catch(Exception e) {
				e.printStackTrace();
			} finally {
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
}
