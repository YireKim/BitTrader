package domain;

import lombok.Data;

public @Data class CustomersDTO {
	
	private String no, customerId, contactName, address, city, postalCode, country, ssn, phone, password, photo;
}
