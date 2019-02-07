package factory;

import java.sql.Connection;
import java.sql.DriverManager;

import enums.Props;
import lombok.Data;
@Data

public class Oracle implements Database {
	
	@Override
	public Connection getConnection() {
		   Connection conn = null;
		  
		try {
			Class.forName(Props.ORA_DRIVER.getValue());
			
			conn = DriverManager.getConnection(
					Props.ORA_URL.getValue(),
					Props.ORA_USER.getValue(), 
					Props.ORA_PASS.getValue());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" .. Oracle");
		return conn;
	}
	

}
