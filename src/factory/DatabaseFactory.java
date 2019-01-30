package factory;

import pool.Constant;

public class DatabaseFactory {

	public static Database createDatabase(String vendor) {
		Database database = null;
		
		
		switch (vendor) {
		
		case "oracle":
			database = new Oracle(
					Constant.ORACLE_DRIVER,
					Constant.ORACLE_URL,
					Constant.ORACLE_USER,
					Constant.ORACLE_PASSWORD);
			break;
		}
		return database;
	}
	
}
