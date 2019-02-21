package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import domain.CustomersDTO;
import domain.ProductsDTO;
import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;
import service.ProductsServiceImpl;

public class RetrieveCommand extends Command {

	public RetrieveCommand(Map<String, Proxy> pxy) {
		super(pxy);

		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();

		HttpSession session = request.getSession();
		
		HashMap<String, Object> map;
		
		//Login conn ???
		session.getAttribute("employee");
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_RETRIEVE:
			
			//Cust id/info IO
			CustomersDTO cust = new CustomersDTO();
			
			cust.setCustomerId(request.getParameter("customer_id"));
			cust = CustomersServiceImpl
					.getInstance()
					.retrieveAnCustomer(cust);	
		
			request.setAttribute("customer", cust);
			
			//Cust img IO
			map = (HashMap<String, Object>) CustomersServiceImpl
					.getInstance()
					.retrieveProfilePic(cust);
			
			request.setAttribute("image", map.get("imagekey"));
			
			System.out.println("RetrieveCommand map Img  == "+ map.get("imagekey"));
			break;
			
		case PROD_RETRIEVE:
			ProductsDTO prod = new ProductsDTO();
			
			prod.setProductId(request.getParameter("product_id"));
			prod = ProductsServiceImpl.getInstance().retrieveAnProduct(prod);
			
			request.setAttribute("product", prod);
			
			map = (HashMap<String, Object>) ProductsServiceImpl
					.getInstance()
					.retrieveProductPic(prod);
			
			request.setAttribute("image", map.get("imagekey"));
			
			break;
			
		default:
			break;
		}
	}
}

