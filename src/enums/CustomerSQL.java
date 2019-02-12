package enums;

public enum CustomerSQL {

	SIGNUP, SIGNIN, LIST, COUNT;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. CUST SQL");
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS ("
					+ "CUSTOMER_ID,"
					+ "CONTACT_NAME,"
					+ "ADDRESS,"
					+ "CITY,"
					+ "POSTAL_CODE,"
					+ "COUNTRY,"
					+ "SSN,"
					+ "PHONE,"
					+ "PASSWORD"
 					+ ")\n" + 
					"VALUES(CUST_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?)");
			break;
			
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ? AND PASSWORD LIKE ?");
			break;

		case LIST:
			query.append("SELECT L.NO\n" + 
					"FROM\n" + 
					"(SELECT T.NO\n" + 
					"FROM\n" + 
					"		(SELECT ROWNUM NO, C.* FROM CUSTOMERS C ORDER BY NO DESC) T\n" + 
					"		WHERE ROWNUM <= ?) L\n" + 
					"WHERE L.NO >= ?");
			break;
			
		case COUNT:
			query.append("SELECT COUNT(*) AS totalCount FROM CUSTOMERS");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
