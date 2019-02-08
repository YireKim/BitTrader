package enums;

public enum CustomerSQL {

	SIGNUP, SELECT, SIGNIN;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. CUST SQL");
		switch (this) {
		case SIGNUP:
			query.append("INSERT INTO CUSTOMERS (CUSTOMER_ID,CONTACT_NAME,ADDRESS,CITY,POSTAL_CODE,COUNTRY) "
					+ "VALUES(CUST_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
			break;
			
		case SELECT:
			query.append("SELECT * FROM CUSTOMERS");
			break;
			
		case SIGNIN:
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ? AND CONTACT_NAME LIKE ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
