package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomersDTO;
import proxy.PageProxy;
import proxy.Pagination;
import service.CustomersServiceImpl;

public class ListCommand extends Command {

	public ListCommand(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		
		PageProxy pageProxy = new PageProxy();
		Pagination pagination = new Pagination();
	
		pagination.carryOut(request);
		pageProxy.carryOut(pagination);
		
		List<CustomersDTO> list = CustomersServiceImpl.getInstance().retrieveListOfCustomers(pagination);

		request.setAttribute("list", list);
			
		System.out.println("LIST comm : list"+list);
	}
	
}
