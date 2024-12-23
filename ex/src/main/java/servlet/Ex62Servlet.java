package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ex62")
public class Ex62Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num = (int)(Math.random() * 10);
		if (num % 2 == 0) {
			RequestDispatcher d = 
					request.getRequestDispatcher("forwarded.jsp");
			d.forward(request, response);
			return;
		} else {
			response.sendRedirect("redirected.jsp");
		}
	}

}
