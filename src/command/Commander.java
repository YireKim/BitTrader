package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.Proxy;
import proxy.RequestProxy;

public class Commander {

    public static Command order(Map<String,Proxy> pxy) {
    	
		System.out.println("=-= [ 3 Commander] ");
		
		Command cmd = null;
		RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		HttpServletRequest request = requestProxy.getRequest();
		
		System.out.println("-  - - 3 Commander IN CMD :::: "+request.getParameter("cmd"));
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
			case MOVE:
				System.out.println("  3 Commander C MOVE cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
			    cmd = new Command(pxy);
				break;
				
			case REGISTER: case SIGNUP:
				System.out.println("  3 Commander C REGISTER cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new CreateCommand(pxy);
				break;
				
			case ACCESS: case SIGNIN:
				System.out.println("  3 Commander C ACCESS cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new ExistCommand(pxy);
				break;
				
			case LIST:
				System.out.println("  3 Commander C LIST cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new ListCommand(pxy);
				break;
				
			case CUST_RETRIEVE:
				cmd = new RetrieveCommand(pxy);
				break;
				
			case CUST_UPDATE_PAGE:
				cmd = new UpdateCommand(pxy);
				break;
				
			case CUST_FILE_UPLOAD:
				System.out.println("  3 Commander C CUST_FILE_UPLOAD cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new FileCommand(pxy);
				break;
		}
		return cmd;
	}
}
