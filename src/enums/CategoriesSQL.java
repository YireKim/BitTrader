package enums;

public enum CategoriesSQL {

	LIST, ROW_COUNT;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. Products SQL");
		switch (this) {
		
		case LIST:
			query.append("SELECT T.* FROM\n" + 
					"					(SELECT R.* FROM\n" + 
					"					(SELECT ROWNUM AS NO, P.* FROM CATEGORIES P ORDER BY NO DESC) R\n" + 
					"					WHERE R.NO <= ?) T\n" + 
					"					WHERE T.NO >= ?");
			break;
			
		case ROW_COUNT:
			query.append("SELECT COUNT(*) AS TOTALCOUNT FROM CATEGORIES");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
