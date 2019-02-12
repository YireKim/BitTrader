package proxy;

import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomersServiceImpl;

@Data
public class Pagination implements Capable {
	private HttpServletRequest request;
	private int pageNum, totalCount, 
				startPage, endPage;
	private boolean prev, next;
	
	@Override
	public void carryOut() {

		HttpServletRequest request = Receiver.cmd.getRequest();
		
		int displayPageNum = 10;

		int tempEndPage = (int)Math.ceil(totalCount/(double)displayPageNum);
		
		this.pageNum = Integer.parseInt(request.getParameter("page_num"));
		this.totalCount = CustomersServiceImpl.getInstance().countEmpCustomer();
		
		endPage = ((int)Math.ceil(pageNum/(double)displayPageNum))*displayPageNum;
	    System.out.println("end p : " + endPage);
	    
	    startPage = endPage - (displayPageNum - 1);
	    System.out.println("start p: " + startPage);
	        
	    	if(endPage > tempEndPage){
	            endPage = tempEndPage;
	        }
	    prev = (startPage==1)?false:true; 
	    next = endPage * displayPageNum >= totalCount ? false : true;
		
	}	
}
