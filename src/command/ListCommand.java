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

public class ListCommand extends Command {

	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		System.out.println("=-= [ List Command ]");
		
		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		Proxy pageProxy = new PageProxy();
		Proxy pagination = new Pagination();
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case LIST:
			System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ LIST IN ");
			
			pagination.carryOut(request);
			pageProxy.carryOut(pagination);
			
			List<CustomersDTO> cust_list = CustomersServiceImpl.getInstance().retrieveListOfCustomers(pageProxy);
			
			request.setAttribute("list", cust_list);
			request.setAttribute("pagination", pagination);
				
			System.out.println("!!!!!! Cust LIST comm : list"+cust_list);
			break;
			
		case PROD_LIST:
			System.out.println(" ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ PROD LIST IN ");
			
			pagination.carryOut(request);
			pageProxy.carryOut(pagination);
				
			List<ProductsDTO> prod_list = ProductsServiceImpl.getInstance().retrieveListOfProducts(pageProxy);
			
			request.setAttribute("list", prod_list);
			request.setAttribute("pagination", pagination);
				
			System.out.println("!!!!!! Prod LIST comm : list"+prod_list);
			break;

		default:
			break;
		}
	}
}
