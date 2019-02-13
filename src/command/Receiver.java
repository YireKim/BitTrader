package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import proxy.Proxy;
import proxy.RequestProxy;
import proxy.ResponseProxy;

public class Receiver {
	
	public static Command cmd = new Command();
	
	public static void init(HttpServletRequest request, HttpServletResponse response) {

		System.out.println("=-= [ 2 Receiver / Proxy_map_req/res ] ");
		
		RequestProxy requestProxy = new RequestProxy();
		ResponseProxy responseProxy = new ResponseProxy();
		
		Map<String,Proxy> pxymap = new HashMap<>();
		
		requestProxy.carryOut(request);
		responseProxy.carryOut(response);
		
		pxymap.put("requestProxy", requestProxy);
		pxymap.put("responseProxy", responseProxy);
		
		cmd = Commander.order(pxymap);
	};
}
