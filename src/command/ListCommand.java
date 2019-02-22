package command;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enums.Action;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CategoriesServiceImpl;
import service.CustomersServiceImpl;
import service.ProductsServiceImpl;

public class ListCommand extends Command {

	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		System.out.println("=-= [ List Command ]");
		
		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		//Login session
		HttpSession session = request.getSession();
		session.getAttribute("employee");
		
		//Pagination
		PageProxy pageproxy = new PageProxy();
		Pagination pagination = new Pagination();
//		Proxy pageProxy = new PageProxy();		//??
//		Proxy pagination = new Pagination();		//??
		
		pagination.carryOut(request);
		pageproxy.carryOut(pagination);
		
		List<?> list = new ArrayList<>();
		
		//Cmd in
		String flag = request.getParameter("cmd").toUpperCase();
		switch (Action.valueOf(flag)) {
		case LIST:
			System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LIST IN ");
			
			list = CustomersServiceImpl.getInstance().retrieveListOfCustomers(pageproxy);
			break;
			
		case PROD_LIST:
			System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PROD LIST IN ");
			
			list = ProductsServiceImpl.getInstance().retrieveListOfProducts(pageproxy);
			break;
			
		case CAT_LIST:
			
			list = CategoriesServiceImpl.getInstance().retrieveListOfCategories(pageproxy);
			break;
			

		default:
			break;
		}
		request.setAttribute("list", list);
		request.setAttribute("pagination", pagination);
	}
}
