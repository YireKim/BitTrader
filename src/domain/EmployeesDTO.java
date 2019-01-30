package domain;

import lombok.Data;

public @Data class EmployeesDTO {
	
	private String employeeId, managerId, name, birthDate, photo, noteInfo;

}
