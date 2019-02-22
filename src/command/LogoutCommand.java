package command;

import java.util.Map;

import javax.servlet.http.HttpSession;

import proxy.Proxy;

public class LogoutCommand extends Command {

	public LogoutCommand(Map<String,Proxy> pxy) {
		super(pxy);
		
		HttpSession session = request.getSession();
		
		session.invalidate();
		
		super.setDomain("home");
		super.setPage("main");
		super.execute();
	}
	
}
