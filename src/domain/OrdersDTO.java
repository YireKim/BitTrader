package domain;

import lombok.Data;

public @Data class OrdersDTO {

	private String seqOrderId, customerId, employeeId, orderDate, shipperId;

	
}
