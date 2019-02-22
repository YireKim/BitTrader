package command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import enums.Action;
import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;
import service.ProductsServiceImpl;

public class FileCommand extends Command {

	public FileCommand(Map<String, Proxy> pxy) {
		super(pxy);
		
		System.out.println("=-= [  File Command ]");
		
		 RequestProxy requestProxy = (RequestProxy) pxy.get("requestProxy");
		 HttpServletRequest request = requestProxy.getRequest();

		 HttpSession session = request.getSession();
		 session.getAttribute("employee");
		 
		 ImageProxy imgpxy = new ImageProxy();
		 imgpxy.carryOut(request);
		 
		 HashMap<String, Object> map = (HashMap<String, Object>) null;
		
	    switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case CUST_FILE_UPLOAD:
			imgpxy.carryOut(request);
			
			map = (HashMap<String, Object>) CustomersServiceImpl
					.getInstance()
					.fileUpload(imgpxy);
			
			request.setAttribute("customer", map.get("customerkey"));
			request.setAttribute("image", map.get("imagekey"));
			break;
			
		case PROD_FILE_UPLOAD:
			imgpxy.carryOut(request);
			
			map = (HashMap<String, Object>) ProductsServiceImpl
					.getInstance()
					.fileUpload(imgpxy);
			
			request.setAttribute("product", map.get("productkey"));
			request.setAttribute("image", map.get("imagekey"));
			break;

		default:
			break;
		}
	    
	}

}
