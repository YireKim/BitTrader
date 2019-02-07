package factory;

import enums.Vendor;

public class DatabaseFactory {

	public static Database createDatabase(Vendor v) {
		
		Database db = null;
		
		System.out.println(" .. DB F");
		switch (v) {
		case ORACLE:
			db = new Oracle();
			break;

		default:
			break;
		}	
		return db;
	}
}
