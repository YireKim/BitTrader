package command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import domain.CustomersDTO;
import domain.ImageDTO;
import enums.Action;
import proxy.ImageProxy;
import proxy.Proxy;
import proxy.RequestProxy;
import service.CustomersServiceImpl;
import service.ImageServiceImpl;

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
			
			imgpxy.getImg().setImgOwner(request.getParameter("customer_id"));
			
			ImageDTO image = imgpxy.getImg();
			String custid = imgpxy.getImg().getImgOwner();
			
			CustomersDTO cust = new CustomersDTO();
			cust.setCustomerId(custid); 
					
			cust = CustomersServiceImpl
				.getInstance()
				.retrieveAnCustomer(cust);
			
			request.setAttribute("image", image);
			request.setAttribute("customer", cust);
			break;

		default:
			break;
		}
	}

}
