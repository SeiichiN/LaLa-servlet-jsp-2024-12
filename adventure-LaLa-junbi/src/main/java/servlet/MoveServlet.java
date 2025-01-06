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

import game.Player;

@WebServlet("/MoveServlet")
public class MoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String dir = request.getParameter("dir");
		HttpSession session = request.getSession();
		Player player = (Player)session.getAttribute("player");
		player.move(dir);
		String thing = player.look();
		request.setAttribute("thing", thing);
		String msg = getMeetMessage(thing);
		List<String> msgList = new ArrayList<>();
		msgList.add(msg);
		request.setAttribute("msgList", msgList);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	private String getMeetMessage(String thing) {
		String msg = switch (thing) {
		case "goblin" -> "ゴブリンが現れた！";
		case "dragon" -> "ドラゴンが現れた！";
		case "potion" -> "ポーションがある！";
		case "ether" -> "エーテルがある！";
		default -> "何もありません";
		};
		return msg;
	}
}
