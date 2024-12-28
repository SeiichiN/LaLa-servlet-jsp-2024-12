package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import game.Ether;
import game.Item;
import game.Player;
import game.Potion;

@WebServlet("/GetItemServlet")
public class GetItemServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String select = request.getParameter("select");
		if (select.equals("take")) {
			String itemType = request.getParameter("item");
			HttpSession session = request.getSession();
			Player player = (Player) session.getAttribute("player");
			Item item = null;
			switch (itemType) {
				case "potion" -> {
					item = (Potion) session.getAttribute("potion");
					session.removeAttribute("potion");
				}
				case "ether" -> {
					item = (Ether) session.getAttribute("ether");
					session.removeAttribute("ether");
				}
			}
			player.take(item);
		}
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
