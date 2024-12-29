package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import game.Dragon;
import game.Ether;
import game.Game;
import game.Goblin;
import game.Player;
import game.Potion;

@WebServlet("/game")
public class GameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Goblin goblin = (Goblin) session.getAttribute("goblin");
		if (goblin == null) {
			goblin = new Goblin("goblin");
			session.setAttribute("goblin", goblin);
		}
		Dragon dragon = (Dragon) session.getAttribute("dragon");
		if (dragon == null) {
			dragon = new Dragon("dragon");
			session.setAttribute("dragon", dragon);
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
		Player player = (Player) session.getAttribute("player");
		if (player == null) {
			player = new Player("太郎");
			session.setAttribute("player", player);
		}
		List<String> msgList = new ArrayList<>();
		msgList.add(player.look(request));
		request.setAttribute("msgList", msgList);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String replay = request.getParameter("replay");
		if (replay != null && replay.length() > 0) {
			if (replay.equals("yes")) {
				HttpSession session = request.getSession();
				session.removeAttribute("player");
				session.removeAttribute("goblin");
				session.removeAttribute("dragon");
				session.removeAttribute("potion");
				session.removeAttribute("ether");
				Game.initMap();
			}			
		}
		doGet(request, response);
	}

}
