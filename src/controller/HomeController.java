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

		if (session.getAttribute("employee") == null) {
			request.setAttribute("compo", "register");
		} else {
			request.setAttribute("compo", "access");
		}
		System.out.println("Home Controller =====ctx: " + session.getAttribute("ctx") + "    " + "====css: "
				+ session.getAttribute("css") + "    " + "=====js: " + session.getAttribute("js") + "    "
				+ "=====employee: " + session.getAttribute("employee"));

		request.getRequestDispatcher("/WEB-INF/view/home/main.jsp").forward(request, response);
	}

}
