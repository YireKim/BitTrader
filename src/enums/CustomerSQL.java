package enums;

public enum CustomerSQL {

	SIGNUP, SIGNIN, LIST, ROW_COUNT, PHONE_NUM, CHK_CUSTID, UPDATE, FILE_UPLOAD, CHANGE_PROFILE, SELECT_PIC, DELETE;
	
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
			
		case CHK_CUSTID:
			System.out.println("2");
			query.append("SELECT * FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;

		case LIST:
			query.append("SELECT T.*\n" + 
					"FROM\n" + 
					"(SELECT R.*\n" + 
					"	FROM\n" + 
					"		(SELECT ROWNUM AS NO, C.* FROM CUSTOMERS C ORDER BY NO DESC) R\n" + 
					"		WHERE R.NO <= ?) T\n" + 
					"WHERE T.NO >= ?");
			break;
			
		case ROW_COUNT:
			System.out.println(" SQL Count in ");
			query.append("SELECT COUNT(*) AS TOTALCOUNT FROM CUSTOMERS");
			break;
			
		case PHONE_NUM:
			query.append("SELECT CUSTOMER_ID, CONTACT_NAME, PHONE FROM CUSTOMERS");
			break;
		case UPDATE:
			query.append("UPDATE CUSTOMERS SET PASSWORD = ?, SSN = ?, PHONE = ?, ADDRESS = ?, CITY = ?, COUNTRY = ? WHERE CUSTOMER_ID LIKE ?");
			break;
			
		case CHANGE_PROFILE:
			query.append("UPDATE CUSTOMERS SET PHOTO = ? WHERE CUSTOMER_ID LIKE ?");
			break;
			
		case SELECT_PIC:
			query.append("SELECT * FROM (SELECT * FROM IMAGE WHERE IMAGE_OWNER LIKE ? ORDER BY IMAGE_ID DESC) WHERE ROWNUM = 1");
			break;
			
		case DELETE:
			query.append("DELETE FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
