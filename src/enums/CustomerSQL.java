package enums;

public enum CustomerSQL {

	SIGNUP, SIGNIN, LIST;
	
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
			query.append("SELECT T.* \n" + 
					"FROM\n" + 
					"(SELECT ROWNUM NO, C.*\n" + 
					"FROM CUSTOMERS C\n" + 
					"ORDER BY NO DESC) T\n" + 
					"WHERE T.NO BETWEEN ? AND ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
