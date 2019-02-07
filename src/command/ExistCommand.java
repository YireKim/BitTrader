package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomersDTO;
import domain.EmployeesDTO;
import service.CustomersServiceImpl;
import service.EmployeesServiceImpl;

public class ExistCommand extends Command{

	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		
		System.out.println(" GET DOMAIN exist ============== "+getDomain());
		switch (getDomain()) {
		case "employee":
			EmployeesDTO emp = new EmployeesDTO();
			
			emp.setEmployeeId(request.getParameter("employee_id"));
			emp.setName(request.getParameter("employee_name"));
			
			boolean exist = EmployeesServiceImpl
					.getInstance()
					.existEmployee(emp);

			if(exist == true) {
				System.out.println("ExistComm - EMP boolean TURE");
			} else {
				System.out.println("ExistComm - EMP boolean FALSE");
				super.setDomain("home");
				super.setPage("main");
				super.execute();
			}
			break;

		case "customer":
			CustomersDTO cust = new CustomersDTO();
			
			cust.setCustomerId(request.getParameter("customer_id"));
			cust.setContactName(request.getParameter("contact_name"));
			
				boolean exist2 = CustomersServiceImpl
					.getInstance()
					.existCustomer(cust);
					
				if(exist2 == true) {
					System.out.println("ExistComm - CUST boolean TURE");
				} else {
					System.out.println("ExistComm - CUST boolean FALSE");
					super.setDomain("home");
					super.setPage("main");
					super.execute();
				}
				break;
			
		default:
			break;
		}
	}
	
}
