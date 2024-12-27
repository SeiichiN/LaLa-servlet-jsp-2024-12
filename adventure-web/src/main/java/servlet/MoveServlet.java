package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import game.Game;
import game.Player;

@WebServlet("/MoveServlet")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getParameter("dir");
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		player.move(dir);
		
		String thing = Game.map[player.getY()][player.getX()];
		String msg = null;
		switch (thing) {
			case "goblin", "dragon" -> {
				request.setAttribute("monster", thing);
				msg = thing + "が現れた！";
			}
			case "potion", "ether" -> {
				request.setAttribute("item", thing);
				msg = thing + "があった！";
			}
			default -> {
				msg = "何も見当たらない";
			}
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}