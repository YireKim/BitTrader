package proxy;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
import service.CustomersServiceImpl;

@Data
public class Pagination implements Proxy {
	private HttpServletRequest request;

	private int pageNum, totalCount, 
				startRow, endRow,
				startPage, endPage, nowPage,
				pageSize, displayPageNum, 
				nextBlock, prevBlock;

	private boolean prev, next;

	@Override
	public void carryOut(Object o) {

		HttpServletRequest request = (HttpServletRequest)o;
		
		System.out.println("=-= [ 7 Pagination ]");
		
		String _pageNum = request.getParameter("page_num");
		pageNum = (_pageNum == null) ? 1 : Integer.parseInt(_pageNum);
//		System.out.println("page num : "+pageNum);

		String _pageSize = request.getParameter("page_size");
		pageSize = (_pageSize == null) ? 5 : Integer.parseInt(_pageSize);		
//		System.out.println("page size : "+pageSize);

		totalCount = CustomersServiceImpl.getInstance().countEmpCustomer(null);
//		System.out.println("total count : "+totalCount);
		
		nowPage = pageNum;
		displayPageNum = 5;
		
//		startRow = ((pageNum - 1) * pageSize) + 1;											//ASC
//		endRow = (totalCount < pageNum * pageSize) ? totalCount : pageNum * pageSize;		//ASC
		startRow = (startRow < 0) ? 1 : totalCount - (pageNum * pageSize) + 1;	//DESC and prevent (-n) row start
		endRow =  startRow + (pageSize - 1);					//DESC
		
		endPage = (int) (Math.ceil(nowPage / (double)displayPageNum) * displayPageNum);	//endPage First
		startPage = (endPage - displayPageNum) + 1;
//		startPage = (int) (Math.ceil(nowPage / (double)displayPageNum) * displayPageNum) - displayPageNum +1;	//startPage First
//		endPage = (startPage + displayPageNum) -1;
		
//		System.out.println("start Page: "+startPage+"    end Page: "+endPage);
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) displayPageNum));
//		System.out.println(" Page Count : "+tempEndPage);
		
		if (endPage > tempEndPage) {	//prevent end page over limit
			endPage = tempEndPage;
		}
		
		prevBlock = startPage - pageSize; 
		nextBlock = startPage + pageSize;
		
		prev = startPage == 1 ? false : true;
		next = endPage == tempEndPage ? false : true; //endPage * pageSize >= totalCount ? false : true;
	}
}
