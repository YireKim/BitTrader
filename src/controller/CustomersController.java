package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/customer.do")
public class CustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String cmd = request.getParameter("cmd");
		cmd = (cmd == null) ? "move" : cmd;
		System.out.println("* mCmd : "+cmd);
		
		String dir = request.getParameter("dir");
		
		if (dir == null) {
			String sPath = request.getServletPath();
			sPath = sPath.replace(".do", "");
			dir = sPath.substring(1);
			System.out.println("* mDir IF : "+dir);
			}
		System.out.println("* mDir : "+dir);
		
		String page = request.getParameter("page");
		page = (page == null) ? "main" : page;
		System.out.println("* mPage : "+page);
		
		
		String dest = request.getParameter("dest");
		dest = (dest == null) ? "NONE" : dest;
		System.out.println("* mDest :  "+dest);
		
		HttpSession session = request.getSession();
		session.setAttribute("ctx", request.getContextPath());
		session.setAttribute("css", session.getAttribute("ctx") + "/resources/css/");
		session.setAttribute("js", session.getAttribute("ctx") + "/resources/js/");
		
		switch (cmd) {
		
		case "move":
			session.setAttribute("dest", dest);
			
			System.out.println("case move in");
			break;
			
		case "join-member":

		case "logout":
			dir = "";
			page = "index";
			dest = "";
			session.invalidate();
			System.out.println("case logout");	
			break;
		
		default:
				System.out.println("mContr DEFAULT WAY!! * which is nowhere..");
				break;
		}
		
		System.out.println("final dest = "+dest);
		System.out.println("*** m Out to > "+dir+"  "+page);
		
		//request.getRequestDispatcher("/WEB-INF/view/employees/main.jsp").forward(request, response);
		
		System.out.println("===== customer controller");
	}
}