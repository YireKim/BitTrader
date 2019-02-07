package enums;

public enum EmployeeSQL {

	EMP_REGISTER, CUST_REGISTER, SELECT, EMP_EXIST, CUST_EXIST;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. Emp SQL");
		switch (this) {
		case EMP_REGISTER:
			query.append("INSERT INTO EMPLOYEES (EMPLOYEE_ID,EMPLOYEE_NAME,BIRTHDATE,PHOTO,NOTE_INFO,MANAGER_ID) "
					+ "VALUES(EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
			break;
			
		case CUST_REGISTER:
			query.append("INSERT INTO CUSTOMERS (CUSTOMER_ID,CONTACT_NAME,ADDRESS,CITY,POSTAL_CODE,COUNTRY) "
					+ "VALUES(CUST_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
			break;
			
		case SELECT:
			query.append("SELECT * FROM EMPLOYEES");
			break;
			
		case EMP_EXIST:
			query.append("SELECT EMPLOYEE_ID,EMPLOYEE_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID LIKE ? AND EMPLOYEE_NAME LIKE ?");
			break;
			
		case CUST_EXIST:
			query.append("SELECT CUSTOMER_ID,CONTACT_NAME FROM CUSTOMERS WHERE CUSTOMER_ID LIKE ? AND CONTACT_NAME LIKE ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
