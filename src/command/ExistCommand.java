package command;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomersDTO;
import domain.EmployeesDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;
import service.EmployeesServiceImpl;

public class ExistCommand extends Command {

	public ExistCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		System.out.println("=-= [ 4 Exist Command ]");
		
	    RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
	    HttpServletRequest request = requestProxy.getRequest();
		
		HttpSession session = request.getSession();
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS:
			System.out.println("=-= 6 Exist Comm : ACCESS IN");
			EmployeesDTO emp = new EmployeesDTO();

			emp.setEmployeeId(request.getParameter("employee_id"));
			emp.setName(request.getParameter("employee_name"));

			emp = EmployeesServiceImpl.getInstance().retrieveAnEmployee(emp);
			if (emp != null) {
				System.out.println(" 6 Exist Comm - ACCESS EMP TURE");
				
				session.setAttribute("employee", emp);
				System.out.println("###### SESSION - employee emp / id,name IN! and emp include >"+emp);
				
				Proxy paging = new Pagination();
				Proxy pagePxy = new PageProxy();
				paging.carryOut(request);
				pagePxy.carryOut(paging);
				
				List<CustomersDTO> list = CustomersServiceImpl.getInstance().retrieveListOfCustomers(pagePxy);

				request.setAttribute("list", list);
				request.setAttribute("pagination", paging);
				
				System.out.println(" List size : "+list.size());
			} else {
				super.setDomain("employee");
				super.setPage("access");
				super.execute();
			}
			break;
		case SIGNIN:
			CustomersDTO cust = new CustomersDTO();

			cust.setCustomerId(request.getParameter("customer_id"));
			cust.setPassword(request.getParameter("customer_password"));

			cust = CustomersServiceImpl.getInstance().retrieveAnCustomer(cust);

			if (cust != null) {
				System.out.println("ExistComm - CUST TURE");
				session.setAttribute("customer", cust);
				
				cust = CustomersServiceImpl
						.getInstance()
						.retrieveAnCustomer(cust);
				
				HashMap<String, Object> map = (HashMap<String, Object>) CustomersServiceImpl
						.getInstance()
						.retrieveProfilePic(cust);
				
				request.setAttribute("image", map.get("imagekey"));
			} else {
				super.setDomain("customer");
				super.setPage("signin");
				super.execute();
			}
			break;
			
		default:
			break;
		}
	}

}
