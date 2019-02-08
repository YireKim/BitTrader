package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import domain.CustomersDTO;
import domain.EmployeesDTO;
import enums.Action;
import service.CustomersServiceImpl;
import service.EmployeesServiceImpl;

public class ExistCommand extends Command{

	public ExistCommand(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		HttpSession session = request.getSession();
		System.out.println(" GET DOMAIN exist comm ============== "+getDomain());

		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			EmployeesDTO emp = new EmployeesDTO();
			
			emp.setEmployeeId(request.getParameter("employee_id"));
			emp.setName(request.getParameter("employee_name"));
			
			emp = EmployeesServiceImpl.getInstance().retrieveAnEmployee(emp);
			
			if(emp != null) {
				System.out.println("ExistComm - EMP boolean TURE");
				session.setAttribute("employee", emp);
			} else {
				System.out.println("ExistComm - EMP boolean FALSE");
				super.setDomain("employee");
				super.setPage("access");
				super.execute();
			}
			break;

		case SIGNIN:
			CustomersDTO cust = new CustomersDTO();
			
			cust.setCustomerId(request.getParameter("customer_id"));
			cust.setContactName(request.getParameter("contact_name"));
			
			cust = CustomersServiceImpl.getInstance().retrieveAnCustomer(cust);
			
				if(cust != null) {
					System.out.println("ExistComm - CUST boolean TURE");
					session.setAttribute("customer", cust);
				} else {
					System.out.println("ExistComm - CUST boolean FALSE");
					super.setDomain("customer");
					super.setPage("access");
					super.execute();
				}
				break;
			
		default:
			break;
		}
	}
	
}
