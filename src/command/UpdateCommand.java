package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import domain.ProductsDTO;
import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;
import service.ProductsServiceImpl;

public class UpdateCommand extends Command{

	public UpdateCommand(Map<String, Proxy> pxy) {
		super(pxy);

		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		List<?> list = null;
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_UPDATE_PAGE:
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
			String city = (request.getParameter("city").equals("")) 
					? cust.getCity() : request.getParameter("city");
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
			break;
			
		case PROD_UPDATE_PAGE:
			ProductsDTO prod = new ProductsDTO();
			prod.setProductId(request.getParameter("product_id"));
			prod = ProductsServiceImpl.getInstance().retrieveAnProduct(prod);
			
			String unit = (request.getParameter("unit").equals("")) 
					? prod.getUnit() : request.getParameter("unit");
			String price = (request.getParameter("price").equals("")) 
					? prod.getPrice() : request.getParameter("price");

			prod.setUnit(unit);
			prod.setPrice(price);
			
			ProductsServiceImpl.getInstance().modifyProduct(prod);
			
			request.setAttribute("product", prod);
			
			//page again..
			Proxy paging = new Pagination();
			Proxy pagePxy = new PageProxy();
			paging.carryOut(request);
			pagePxy.carryOut(paging);
			
			list = ProductsServiceImpl.getInstance().retrieveListOfProducts(pagePxy);

			request.setAttribute("list", list);
			request.setAttribute("pagination", paging);
			break;
			
		default:
			break;
		}
	}
}

