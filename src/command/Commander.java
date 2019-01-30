package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import enums.Action;

public class Commander {

	public static Command order(HttpServletRequest request, HttpServletResponse response) {
		Command cmd = null;
		
		System.out.println("=-=-=-=-=-=-= [ 3 Commander] ");
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
			case MOVE:
				System.out.println("  3 INNNNNNN and cmder cmd : "+cmd);
				cmd = new MoveCommand(request,response);
				break;
				
				default:
					break;
		}
		System.out.println("  3 OUTTTTTTT and cmder cmd : "+cmd);
		return cmd;
	}
}
