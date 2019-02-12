package command;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Carrier {

	public static void forward(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		System.out.println("=-=[ 6 Carrier ] ");
		
		request.getRequestDispatcher(Receiver.cmd.getView())
		.forward(request, response);
		
		System.out.println(" 6  Dispatcher(Reciver.cmd.getView.forward) => "+Receiver.cmd.getView());
	}
}
