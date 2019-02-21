package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import domain.EmployeesDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;
import service.EmployeesServiceImpl;

public class CreateCommand extends Command {

	public CreateCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();

		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case REGISTER:
			System.out.println("=-= [ 4-2 Create comm EMP ] ");

			EmployeesDTO emp = new EmployeesDTO();
			emp.setName(request.getParameter("employeeName"));
			emp.setBirthDate(request.getParameter("birthDate"));
			emp.setNoteInfo(request.getParameter("noteInfo"));
			emp.setManagerId(request.getParameter("managerId"));

			EmployeesServiceImpl.getInstance().addEmployee(emp);
			break;

		case SIGNUP:
			System.out.println("=-= [ 4-2 Create comm CUST ] ");

			CustomersDTO cust = new CustomersDTO();
			cust.setContactName(request.getParameter("cust_contact_name"));
			cust.setAddress(request.getParameter("cust_address"));
			cust.setCity(request.getParameter("cust_city"));
			cust.setPostalCode(request.getParameter("cust_postalcode"));
			cust.setCountry(request.getParameter("cust_country"));
			cust.setSsn(request.getParameter("cust_ssn"));
			cust.setPhone(request.getParameter("cust_phone"));
			cust.setPassword(request.getParameter("cust_password"));

			CustomersServiceImpl.getInstance().addCustomer(cust);
			break;
		default:
			break;
		}

	}
}
