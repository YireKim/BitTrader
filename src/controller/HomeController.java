package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/home.do")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("ctx", request.getContextPath());
		session.setAttribute("css", session.getAttribute("ctx") + "/resources/css/");
		session.setAttribute("js", session.getAttribute("ctx") + "/resources/js/");
		session.setAttribute("imgpath", session.getAttribute("ctx") + "/resources/img/");
		
		System.out.println("==============Home Controller "
				+ "\n=====ctx: "+ session.getAttribute("ctx")
				+ "\n=====css: "+ session.getAttribute("css")
				+ "\n=====js: " + session.getAttribute("js")
				+ "\n=====img: " + session.getAttribute("img")
				+ "\n=====employee: " + session.getAttribute("employee"));

		
		if (session.getAttribute("employee") == null) {
			request.setAttribute("compo", "register");
		} else {
			request.setAttribute("compo", "access");
		}
		
		request.getRequestDispatcher("/WEB-INF/view/home/main.jsp").forward(request, response);
	}

}
