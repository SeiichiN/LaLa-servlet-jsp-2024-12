package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.Human;

@WebServlet("/HumanServlet")
public class HumanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Human human = new Human();
		human.setName("湊 雄輔");
		human.setAge(23);
		
		HttpSession session = request.getSession();
		session.setAttribute("human", human);
		
		String url = "WEB-INF/jsp/human.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
