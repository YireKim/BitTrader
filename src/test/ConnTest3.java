package test;

import enums.EmployeeSQL;
import enums.Vendor;
import factory.DatabaseFactory;

public class ConnTest3 {

	public static void main(String[] args) {
			
			try {
				int rs =
						DatabaseFactory
						.createDatabase(Vendor.ORACLE)
						.getConnection()
						.prepareStatement(EmployeeSQL.LIST.toString())
						.executeUpdate();
				
						System.out.println(rs);
				
			} catch(Exception e) {
				e.printStackTrace();
			} 
		}
}
