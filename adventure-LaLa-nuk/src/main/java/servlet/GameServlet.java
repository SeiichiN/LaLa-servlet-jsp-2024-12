package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import game.Game;
import game.Player;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Player player = (Player)session.getAttribute("player");
		Game game = new Game();
		if (player == null) {
			player = new Player("太郎", game);
		}
		session.setAttribute("player", player);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
