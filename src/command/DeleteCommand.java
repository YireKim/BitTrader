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

public class DeleteCommand extends Command{

	public DeleteCommand(Map<String, Proxy> pxy) {
		super(pxy);

		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		//Pagination
		Proxy paging = new Pagination();
		Proxy pagePxy = new PageProxy();
		paging.carryOut(request);
		pagePxy.carryOut(paging);
		
		List<?> list = null;
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_DELETE:
			CustomersDTO cust = new CustomersDTO();
			
			cust.setCustomerId(request.getParameter("customer_id"));
			
			request.setAttribute("customer", cust);
			
			CustomersServiceImpl.getInstance().removceCustomer(cust);
		
			//page again..
			list = CustomersServiceImpl.getInstance().retrieveListOfCustomers(pagePxy);
			
			//Out
			super.setDomain("customer");
			super.setPage("list");
			super.execute();
		
			break;
			
		case PROD_DELETE:
			ProductsDTO prod = new ProductsDTO();
			
			prod.setProductId(request.getParameter("product_id"));
			
			request.setAttribute("prodduct", prod);
			
			ProductsServiceImpl.getInstance().removceProduct(prod);		
		
			//page again..
			list = ProductsServiceImpl.getInstance().retrieveListOfProducts(pagePxy);
			
			//Out
			super.setDomain("product");
			super.setPage("main");
			super.execute();
			
			break;
			
			
		default:
			break;
		}
		request.setAttribute("list", list);
		request.setAttribute("pagination", paging);
	}
}
