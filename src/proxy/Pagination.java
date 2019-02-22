package proxy;

import javax.servlet.http.HttpServletRequest;

import enums.Action;
import lombok.Data;
import service.CategoriesServiceImpl;
import service.CustomersServiceImpl;
import service.ProductsServiceImpl;

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

		String _pageSize = request.getParameter("page_size");
		pageSize = (_pageSize == null) ? 10 : Integer.parseInt(_pageSize);		

		totalCount = 1;
		
		switch (Action.valueOf(request.getParameter("cmd").toUpperCase())) {
		case ACCESS: case LIST: case CUST_DELETE:
			totalCount = CustomersServiceImpl.getInstance().countEmpCustomer(null);
			break;

		case PROD_LIST: case PROD_UPDATE_PAGE: case PROD_DELETE: 
			totalCount = ProductsServiceImpl.getInstance().countProduct(null);
			break;
			
		case CAT_LIST:
			totalCount = CategoriesServiceImpl.getInstance().countCategory(null);
			break;
			
		default:
			break;
		}
		
		nowPage = pageNum;
		displayPageNum = 10;

//		startRow = ((pageNum - 1) * pageSize) + 1;											//ASC
//		endRow = (totalCount < pageNum * pageSize) ? totalCount : pageNum * pageSize;		//ASC
		startRow = (startRow < 0) ? 1 : totalCount - (pageNum * pageSize) + 1;	//DESC and prevent (-n) row start
		endRow =  startRow + (pageSize - 1);					//DESC
		
		endPage = (int) (Math.ceil(nowPage / (double)displayPageNum) * displayPageNum);	//endPage First
		startPage = (endPage - displayPageNum) + 1;
//		startPage = (int) (Math.ceil(nowPage / (double)displayPageNum) * displayPageNum) - displayPageNum +1;	//startPage First
//		endPage = (startPage + displayPageNum) -1;
		
		int tempEndPage = (int) (Math.ceil(totalCount / (double) displayPageNum));
		
		if (endPage > tempEndPage) {	//prevent end page over limit
			endPage = tempEndPage;
		}
		
		prevBlock = startPage - pageSize; 
		nextBlock = startPage + pageSize;
		
		prev = startPage == 1 ? false : true;
		next = endPage == tempEndPage ? false : true; //endPage * pageSize >= totalCount ? false : true;
	}
}
