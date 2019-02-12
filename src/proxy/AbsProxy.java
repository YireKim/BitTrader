package proxy;

import javax.servlet.http.HttpServletRequest;

public abstract class AbsProxy {
	
	public AbsProxy() {
		HttpServletRequest request;
		
	}
	
	public abstract void carryOut();
}
