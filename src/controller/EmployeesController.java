package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import command.Carrier;
import command.Receiver;
import enums.Action;

@WebServlet("/employee.do")
public class EmployeesController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("=-=-=-=-=-=-= [ 1 emp cont] ");
		
		Receiver.init(request, response);  // 1 to 5 << was Receiver area
		System.out.println("=-=-=-=-=-=-= [ 1 emd : "+Receiver.cmd);
		switch (Action.valueOf(Receiver.cmd.getAction().toUpperCase())) {
		case MOVE:
			System.out.println(" LAST 1 MOVE Carrier Forward");
			Carrier.forward(request, response);
			break;
			
			default:
				break;
		}
	}
}