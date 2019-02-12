package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {

	public static Command order(HttpServletRequest request, HttpServletResponse response) {
  //public static Command order(Map<String,Proxy> pxy) {
		
		//RequestProxy req = (RequestProxy) pxy.get("req");
		//HttpServletRequest request = req.getRequest();
		
		System.out.println("=-= [ 3/5 Commander] ");
		
		Command cmd = null;
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
			case MOVE:
				System.out.println("  3 Commander C MOVE cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
			  //cmd = new Command(pxy);
				cmd = new Command(request, response);
				break;
				
			case REGISTER: case SIGNUP:
				System.out.println("  3 Commander C REGISTER cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new CreateCommand(request,response);
				break;
				
			case ACCESS: case SIGNIN:
				System.out.println("  3 Commander C EXIST cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new ExistCommand(request,response);
				break;
				
			case LIST:
				System.out.println("  3 Commander C EXIST cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new ListCommand(request,response);
				break;
				
		}
		return cmd;
	}
}
