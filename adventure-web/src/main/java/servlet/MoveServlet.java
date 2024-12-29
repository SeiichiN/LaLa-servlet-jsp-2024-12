package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import game.Game;
import game.Player;

@WebServlet("/MoveServlet")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getParameter("dir");
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		if (player == null) {
			response.sendRedirect("game");
			return;
		}
		List<String> msgList = new ArrayList<>();
		String msg = player.move(dir);
		if (msg != null && msg.length() != 0) {
			msgList.add(msg);
		}
		msgList.add(player.look(request));
		request.setAttribute("msgList", msgList);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
