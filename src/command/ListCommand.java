package command;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import proxy.PageProxy;
import proxy.Pagination;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;

public class ListCommand extends Command {

	public ListCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		System.out.println("=-= [ List Command ]");
		
		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		PageProxy pageProxy = new PageProxy();
		Pagination pagination = new Pagination();
	
		pagination.carryOut(request);
		pageProxy.carryOut(pagination);
		
		List<CustomersDTO> list = CustomersServiceImpl.getInstance().retrieveListOfCustomers(pageProxy);

		request.setAttribute("list", list);
			
		System.out.println("LIST comm : list"+list);
	}
	
}
