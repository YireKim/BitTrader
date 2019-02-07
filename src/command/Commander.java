package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {

	public static Command order(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("=-= [ 3 Commander] ");
		
		Command cmd = null;
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
			case MOVE:
				System.out.println("  3 Commander C MOVE cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new Command(request, response);
				cmd.execute();
				break;
				
			case REGISTER:
				System.out.println("  3 Commander C REGISTER cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new CreateCommand(request,response);
				cmd.execute();
				break;
				
			case EXIST:
				System.out.println("  3 Commander C EXIST cmd : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
				cmd = new ExistCommand(request,response);
				cmd.execute();
				break;
				
				default:
					cmd = new Command(request, response);
					cmd.execute();
					break;
		}
		System.out.println("  3 Commander CMD : "+Action.valueOf(request.getParameter("cmd").toUpperCase()));
		return cmd;
	}
}
