package enums;

public enum EmployeeSQL {

	REGISTER, LIST, ACCESS;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. Emp SQL");
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES ("
					+ "EMPLOYEE_ID,"
					+ "EMPLOYEE_NAME,"
					+ "BIRTHDATE,"
					+ "NOTE_INFO,"
					+ "MANAGER_ID"
					+ ") "
					+ "VALUES(EMP_SEQ.NEXTVAL, ?, ?, ?, ?)");
			break;
			
		case ACCESS:
			query.append("SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID LIKE ? AND EMPLOYEE_NAME LIKE ?");
			break;

		case LIST:
			query.append("SELECT * FROM EMPLOYEES");
			break;
			
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
