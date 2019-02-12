package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;
@Data

public class Command implements Order{
	
	protected HttpServletRequest request;
	protected String action, domain, page, view, page_num, page_size, page_start, page_end, displaypage;
	
	public Command(HttpServletRequest request, HttpServletResponse response) {
		
		setRequest(request);
		setAction(request.getParameter("cmd"));

		setPage_num(request.getParameter("page_num"));
		setPage_size(request.getParameter("page_size"));
		setPage_start(request.getParameter("page_start"));
		setPage_end(request.getParameter("page_end"));
		setDisplaypage(request.getParameter("displaypage"));
		
		String dir = request.getParameter("dir");
		if(dir == null) {
			setDomain(request.getServletPath().split("/")[1].replace(".do", ""));			
		} else {
			setDomain(dir);			
		}
		
		setPage(request.getParameter("page"));
		execute();
		
		System.out.println("=-= [ 5 Command ]"
				+ "\n[ action/cmd : "+action+" ]"
				+ "\n[ doma : "+domain+" ]"
				+ "\n[ dir : "+dir+" ]"
				+ "\n[ page : "+page+" ]"
				+ "\n[ view : "+view+" ]\n"
				+ "\n"
				+ "\n[ page_num : "+page_num+" ]\n"
				+ "\n[ page_start : "+page_start+" ]\n"
				+ "\n[ page_end : "+page_end+" ]\n"
				+ "\n[ page_size : "+page_size+" ]\n"
				+ "\n[ displayPage : "+displaypage+" ]");
	}
	
	public Command() {}

	@Override
	public void execute() {		
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
	}
	

}
