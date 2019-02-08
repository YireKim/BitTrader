package enums;

public enum EmployeeSQL {

	REGISTER, SELECT, ACCESS;
	
	@Override
	public String toString() {
		StringBuffer query = new StringBuffer();
		
		System.out.println(" .. Emp SQL");
		switch (this) {
		case REGISTER:
			query.append("INSERT INTO EMPLOYEES (EMPLOYEE_ID,EMPLOYEE_NAME,BIRTHDATE,PHOTO,NOTE_INFO,MANAGER_ID) "
					+ "VALUES(EMP_SEQ.NEXTVAL, ?, ?, ?, ?, ?)");
			break;
			
		case SELECT:
			query.append("SELECT * FROM EMPLOYEES");
			break;
			
		case ACCESS:
			query.append("SELECT EMPLOYEE_ID,EMPLOYEE_NAME FROM EMPLOYEES WHERE EMPLOYEE_ID LIKE ? AND EMPLOYEE_NAME LIKE ?");
			break;
			
		default:
			break;
		}
		return query.toString();
	}
	
	
}
