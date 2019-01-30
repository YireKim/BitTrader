package command;

import javax.servlet.http.HttpServletRequest;

import lombok.Data;
@Data

public class Command implements Order{
	
	protected HttpServletRequest request;
	protected String action, domain, page, view;
	
	@Override
	public void execute() {
		System.out.println("=-=-=-=-=-=-= [ 5 Command : void -> view set/execute() ] ");
		System.out.println("5  action : "+action+"  //  "+"domain : "+domain+"  //  page :"+page+"  //  "+"view : "+view);
		this.view = "/WEB-INF/view/"+domain+"/"+page+".jsp";
		
		System.out.println("====== 5 view     "+view);
		
	}

}
