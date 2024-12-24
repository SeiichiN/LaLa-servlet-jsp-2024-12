package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Human;

@WebServlet("/HumanServlet")
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Human human = new Human("湊 雄輔", 23);
		request.setAttribute("human", human);
		
		String url = "WEB-INF/jsp/human.jsp";
		RequestDispatcher d =
				request.getRequestDispatcher(url);
		d.forward(request, response);
	}

}
