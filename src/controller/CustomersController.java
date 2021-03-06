package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;

@WebServlet("/customer.do")
public class CustomersController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("=-= [ 2 Customer controller] ");
		
		Receiver.init(request, response); 
		
		Carrier.forward(request, response);
		
		System.out.println(" 1 Customer contr last out WITH \n"
				+ "[ request : "+request+"\n"
				+ "[ response : "+response);
	}
}