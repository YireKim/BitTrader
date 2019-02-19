package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;

public class UpdateCommand extends Command{

	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);

		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		CustomersDTO cust = new CustomersDTO();
		cust.setCustomerId(request.getParameter("customer_id"));
		cust = CustomersServiceImpl.getInstance().retrieveAnCustomer(cust);
		
		String password = (request.getParameter("password").equals("")) 
				? cust.getPassword() : request.getParameter("password");
		String ssn = (request.getParameter("ssn").equals("")) 
				? cust.getSsn() : request.getParameter("ssn");
		String phone = (request.getParameter("phone").equals("")) 
				? cust.getPhone() : request.getParameter("phone");
		String address = (request.getParameter("address").equals("")) 
				? cust.getAddress() : request.getParameter("address");
		String city = (request.getParameter("city").equals("")) ? cust.getCity() : request.getParameter("city");
		String country = (request.getParameter("country").equals("")) 
				? cust.getCountry() : request.getParameter("country");
		
		cust.setPassword(password);
		cust.setSsn(ssn);
		cust.setPhone(phone);
		cust.setAddress(address);
		cust.setCity(city);
		cust.setCountry(country);
		
		CustomersServiceImpl.getInstance().modifyCustomer(cust);
		
		request.setAttribute("customer", cust);		
			}
		}
