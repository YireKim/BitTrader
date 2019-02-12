package command;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import domain.CustomersDTO;
import enums.Action;
import proxy.Proxy;
import service.CustomersServiceImpl;

public class ListCommand extends Command {

	public ListCommand(HttpServletRequest request, HttpServletResponse response) {
		
		super(request, response);
		
		System.out.println(page);
		System.out.println(page_num);
		System.out.println(page_start);
		System.out.println(page_end);
		
		switch(Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case LIST:
			List<CustomersDTO> list = CustomersServiceImpl.getInstance().retrieveListOfCustomers(new Proxy().getPage());

			request.setAttribute("list", list);
			System.out.println("LIST comm : cmd"+page_num);
			System.out.println("LIST comm : list"+list);
			break;
			
		default:
			break;
		
		}
	}
	
}
