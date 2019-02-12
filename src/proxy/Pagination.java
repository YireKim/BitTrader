package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomersServiceImpl;

@Data
public class Pagination implements Proxy {
	private HttpServletRequest request;
	
	private int pageNum, totalCount, startPage, endPage, displayPageNum, pageSize, blockSize;
	private boolean prev, next;

	@Override
	public void carryOut(Object o) {

		HttpServletRequest request = (HttpServletRequest)o;
		
		String _pageNum = request.getParameter("page_num");
		pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
		
		String _pageSize = request.getParameter("page_size");
		pageSize = (_pageSize == null) ? 10 : Integer.parseInt(_pageSize);
		
		String _blockSize = request.getParameter("block_size");
		blockSize = (_blockSize == null) ? 10 : Integer.parseInt(_blockSize);

		displayPageNum = CustomersServiceImpl.getInstance().countEmpCustomer();
		
		startPage = (pageNum-1) * (pageSize+1);
		System.out.println("start ROW: "+startPage);
		
		endPage = (displayPageNum > pageNum * pageSize)?
				pageNum * pageSize : endPage;
		System.out.println("end ROW : "+endPage);

	}

}
