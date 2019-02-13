package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomersServiceImpl;

@Data
public class Pagination implements Proxy {
	private HttpServletRequest request;

	private int pageNum, totalCount, 
				startRow, endRow,
				startPage, endPage, 
				pageSize, displayPageNum, 
				blockSize;
	private boolean prev, next;

	@Override
	public void carryOut(Object o) {

		HttpServletRequest request = (HttpServletRequest)o;
		
		System.out.println("=-= [ 7 Pagination ]");
		
		String _pageNum = request.getParameter("page_num");
		pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
		System.out.println("page num : "+pageNum);

		String _pageSize = request.getParameter("page_size");
		pageSize = (_pageSize == null) ? 10 : Integer.parseInt(_pageSize);		
		System.out.println("page size : "+pageSize);

		displayPageNum = 10;	

		totalCount = CustomersServiceImpl.getInstance().countEmpCustomer(null);
		System.out.println("total count : "+totalCount);
	
//		startPage = ((pageNum - 1) * pageSize) + 1; ASC
		startRow = totalCount - (pageNum * pageSize) + 1; //DESC
		
//		endPage = (totalCount < pageNum * pageSize) ? totalCount : pageNum * pageSize; ASC
		endRow =  startRow + (pageSize - 1); //DESC

		startRow = (startRow < 0) ? 1 : startRow;
		
		endPage = (int) (pageNum / (double) displayPageNum) * (displayPageNum);
		startPage = (endPage - displayPageNum) + 1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) pageSize));
		System.out.println(" Page Count : "+tempEndPage);
		
		if (pageNum > tempEndPage || pageNum < 0) {
			pageNum = 1;
			}  
		
		prev = startPage == 1 ? false : true;
		next = endPage * pageSize >= totalCount ? false : true;

	}

}
