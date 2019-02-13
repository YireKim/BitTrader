package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;

@Data
public class RequestProxy implements Proxy {
	private HttpServletRequest request;

	@Override
	public void carryOut(Object o) {
		
		System.out.println(" =-= 3 REQUEST PXY ");
		
		if ((HttpServletRequest) o != null) {
			setRequest((HttpServletRequest) o);
		} else {
			
		}

	}

}