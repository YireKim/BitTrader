package proxy;

import javax.servlet.http.HttpServletRequest;

import command.Receiver;
import lombok.Data;
import service.CustomersServiceImpl;

@Data
public class Pagination implements Capable {
	private HttpServletRequest request;
	private int pageNum, pageSize, blockSize, totalCount, 
				startPage, endPage, startRow, endRow,
				prevBlock, nextBlock,
				displayRow, displayPage;
	private boolean existPrev, existNext;
	
	@Override
	public void carryOut() {

		HttpServletRequest request = Receiver.cmd.getRequest();
		
		this.pageNum = Integer.parseInt(request.getParameter("page_num"));
		//this.totalCount = CustomersServiceImplpl.getInstance().countEmpCustomer();
		this.totalCount = 57;
		this.displayRow = 10;
		this.displayPage = 10;
		
			endPage = ((int)Math.ceil(pageNum/(double)displayPage))*displayPage;
	        System.out.println("end p : " + endPage);
	        
	        startPage = endPage - (displayPage - 1);
	        System.out.println("start p: " + startPage);
	        
	        int totalPage = (int)Math.ceil(totalCount/(double)displayRow);
	        
	        if(totalPage<endPage){
	            endPage = totalPage;
	            existNext = false;
	        }else{
	        	existNext = true;
	        }
	        existPrev = (startPage==1)?false:true; 
		
	}	
}
