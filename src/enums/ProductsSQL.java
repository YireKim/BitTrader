package enums;

public enum ProductsSQL {

	ROW_COUNT, LIST, CHK_PRODID, UPDATE;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. Products SQL");
		switch (this) {
		
		case UPDATE:
			query.append("UPDATE PRODUCTS SET UNIT= ?, PRICE= ? WHERE SEQ_PRODUCT_ID LIKE ?");
			break;
			
		case CHK_PRODID:
			query.append("SELECT * FROM PRODUCTS WHERE SEQ_PRODUCT_ID LIKE ?");
		break;
		
		case ROW_COUNT:
			query.append("SELECT COUNT(*) AS TOTALCOUNT FROM PRODUCTS");
			break;
			
		case LIST:
			query.append("SELECT T.* FROM\n" + 
					"	(SELECT R.* FROM\n" + 
					"		(SELECT ROWNUM AS NO, P.* FROM PRODUCTS P ORDER BY NO DESC) R \n" + 
					"WHERE R.NO <= ?) T\n" + 
					"WHERE T.NO >= ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
