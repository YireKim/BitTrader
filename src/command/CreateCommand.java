package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomersDTO;
import domain.EmployeesDTO;
import service.CustomersServiceImpl;
import service.EmployeesServiceImpl;

public class CreateCommand extends Command{
	
	public CreateCommand(HttpServletRequest request, HttpServletResponse response) {

		super(request, response);
		
		System.out.println("getDomain ====== "+getDomain());
		
		switch (getDomain()) {
		case "employee":
			System.out.println("=-= [ 4-2 Create comm EMP ] ");
			
			EmployeesDTO emp = new EmployeesDTO();
			emp.setName(request.getParameter("employeeName"));
			emp.setBirthDate(request.getParameter("birthDate"));
			emp.setPhoto(request.getParameter("photo"));
			emp.setNoteInfo(request.getParameter("noteInfo"));
			emp.setManagerId(request.getParameter("managerId"));
			
			EmployeesServiceImpl.getInstance().addEmployee(emp);
			break;

		case "customer":
			System.out.println("=-= [ 4-2 Create comm CUST ] ");
			
			CustomersDTO cust = new CustomersDTO();
			cust.setContactName(request.getParameter("cust_contact_name"));
			cust.setAddress(request.getParameter("cust_address"));
			cust.setCity(request.getParameter("cust_city"));
			cust.setPostalCode(request.getParameter("cust_postalcode"));
			cust.setCountry(request.getParameter("cust_country"));
			
			CustomersServiceImpl.getInstance().addCustomer(cust);
			break;
		default:
			break;
		}
		
		super.execute();
	}
}
