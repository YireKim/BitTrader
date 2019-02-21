package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;

public class FileCommand extends Command {

	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		
		System.out.println("=-= [  File Command ]");
		
		 RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		 HttpServletRequest request = requestProxy.getRequest();
		
	    System.out.println("@@@ File comm :CMD ::: "+request.getParameter("cmd"));
	    
	    switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_FILE_UPLOAD:
			System.out.println("@@@ File comm UPLOAD IN!!! ::: "+request.getParameter("cmd"));
			
			ImageProxy imgpxy = new ImageProxy();
			imgpxy.carryOut(request);
			
//			request.setAttribute("map", CustomersServiceImpl.getInstance().fileUpload(imgpxy));
			
			HashMap<String, Object> map = (HashMap<String, Object>) CustomersServiceImpl
					.getInstance()
					.fileUpload(imgpxy);
			
			request.setAttribute("customer", map.get("customerkey"));
			request.setAttribute("image", map.get("imagekey"));
			break;

		default:
			break;
		}
	}

}
