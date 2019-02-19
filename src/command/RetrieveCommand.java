package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import domain.ImageDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;

public class RetrieveCommand extends Command {

	public RetrieveCommand(Map<String, Proxy> pxy) {
		super(pxy);

		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();

		CustomersDTO cust = new CustomersDTO();
		ImageDTO img = new ImageDTO();
	
		cust.setCustomerId(request.getParameter("customer_id"));
		cust = CustomersServiceImpl
				.getInstance()
				.retrieveAnCustomer(cust);
			
		request.setAttribute("customer", cust);
		request.setAttribute("img", img);	
			}
		}

