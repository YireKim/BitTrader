package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;

public class RetrieveCommand extends Command {

	public RetrieveCommand(Map<String, Proxy> pxy) {
		super(pxy);

		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();

		CustomersDTO cust = new CustomersDTO();
		
		cust.setCustomerId(request.getParameter("customer_id"));
		cust = CustomersServiceImpl
				.getInstance()
				.retrieveAnCustomer(cust);
	
		request.setAttribute("customer", cust);
		
		
		HashMap<String, Object> map = (HashMap<String, Object>) CustomersServiceImpl
				.getInstance()
				.retrieveProfilePic(cust);
		
		request.setAttribute("image", map.get("imagekey"));
		
		System.out.println("RetrieveCommand map Img  == "+ map.get("imagekey"));
			}
		}

