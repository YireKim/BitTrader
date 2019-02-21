package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;

public class DeleteCommand extends Command{

	public DeleteCommand(Map<String, Proxy> pxy) {
		super(pxy);

		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_DELETE:
			CustomersDTO cust = new CustomersDTO();
			
			cust.setCustomerId(request.getParameter("customer_id"));
			
			request.setAttribute("customer", cust);
			
			CustomersServiceImpl.getInstance().removceCustomer(cust);
		
			super.setDomain("home");
			super.setPage("main");
			super.execute();
		
			break;
			
			
		default:
			break;
			
		}
	}
}
