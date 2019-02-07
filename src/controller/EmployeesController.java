package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;

@WebServlet("/employee.do")
public class EmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("=-= [ 1 EMP controller] ");
		
		Receiver.init(request, response);  // 1 to 5 << was Receiver area
			
	
		Carrier.forward(request, response);
		
		System.out.println(" 1 Emp contr last out WITH \n"
				+ "[ request : "+request+"\n"
				+ "[ response : "+response);
	}
}