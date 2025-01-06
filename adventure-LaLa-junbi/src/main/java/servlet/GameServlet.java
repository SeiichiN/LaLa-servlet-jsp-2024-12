package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import game.Dragon;
import game.Ether;
import game.Goblin;
import game.Player;
import game.Potion;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Player player = (Player)session.getAttribute("player");
		if (player == null) {
			player = new Player("太郎");
			session.setAttribute("player", player);
		}
		create(session);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private void create(HttpSession session) {
		Dragon dragon = (Dragon) session.getAttribute("dragon");
		if (dragon == null) {
			dragon = new Dragon("dragon");
			session.setAttribute("dragon", dragon);
		}
		Goblin goblin = (Goblin) session.getAttribute("goblin");
		if (goblin == null) {
			goblin = new Goblin("goblin");
			session.setAttribute("goblin", goblin);
		}
		Potion potion = (Potion) session.getAttribute("potion");
		if (potion == null) {
			potion = new Potion("potion");
			session.setAttribute("potion", potion);
		}
		Ether ether = (Ether) session.getAttribute("ether");
		if (ether == null) {
			ether = new Ether("ether");
			session.setAttribute("ether", ether);
		}
		
	}

}
