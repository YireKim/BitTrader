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
				System.out.println("  3 Commander C EXIST cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new ExistCommand(pxy);
				break;
				
			case LIST:
				System.out.println("  3 Commander C EXIST cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new ListCommand(pxy);
				break;
				
		}
		return cmd;
	}
}
