package ex;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FruitServlet")
public class FruitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Fruit fruit = new Fruit("いちご", 700);
		ServletContext application = this.getServletContext();
		application.setAttribute("fruit", fruit);
		String url = "WEB-INF/ex/fruit.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
