package command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.Data;

@Data

public class Command implements Order {

	protected HttpServletRequest request;
	protected String action, domain, page, view;

	public Command() {
	}

	public Command(HttpServletRequest request, HttpServletResponse response) {
		// public Command(Map<String,Proxy> pxy) {

		// RequestProxy req = (RequestProxy) pxy.get("req");

		setRequest(request);
		setAction(request.getParameter("cmd"));

		String dir = request.getParameter("dir");

		if (dir == null) {
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
				+ "\n[ view : "+view+" ]\n");
	}

	@Override
	public void execute() {
		this.view = "/WEB-INF/view/" + domain + "/" + page + ".jsp";
	}

}
