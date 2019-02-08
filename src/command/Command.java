package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;
@Data

public class Command implements Order{
	
	protected HttpServletRequest request;
	protected String action, domain, page, view;

	public Command(HttpServletRequest request, HttpServletResponse response) {
		
		setRequest(request);
		setAction(request.getParameter("cmd"));
		String dir = request.getParameter("dir");
		
		System.out.println("=-= [ 5 Command ]"
				+ "\n[ action/cmd : "+action+" ]"
				+ "\n[ doma : "+domain+" ]"
				+ "\n[ dir : "+dir+" ]"
				+ "\n[ page : "+page+" ]"
				+ "\n[ view : "+view+" ]\n");
		
		if(dir == null) {
			setDomain(request.getServletPath().split("/")[1].replace(".do", ""));			
		} else {
			setDomain(dir);			
		}
		setPage(request.getParameter("page"));
		execute();
	}
	
	public Command() {}

	@Override
	public void execute() {		
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
	}
	

}
