package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnTest {

	public static void main(String[] args) {
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;
			
			try {
				Class.forName("oracle.jdbc.OracleDriver");
				conn = DriverManager.getConnection(
						"jdbc:oracle:thin:@localhost:59162:xe",
						"Eli",
						"2213");
				
				stmt = conn.createStatement();
				rs = stmt.executeQuery("SELECT * FROM employees");
				
				String name = "";
				
				while(rs.next()){
					name = rs.getString("employee_name");
				}
				System.out.println("Member name is === > "+name);
				
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
