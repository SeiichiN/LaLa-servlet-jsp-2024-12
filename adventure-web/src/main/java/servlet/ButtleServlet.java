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

import game.Monster;
import game.Player;

@WebServlet("/ButtleServlet")
public class ButtleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String monster = request.getParameter("monster");
		String select = request.getParameter("select");
		HttpSession session = request.getSession();
		Player player = (Player) session.getAttribute("player");
		List<String> msgList = new ArrayList<>();
		if (select.equals("fight")) {
			Monster monsterObj = (Monster) session.getAttribute(monster);
			List<String>  pList = player.attack(monsterObj);
			if (pList != null) { msgList.addAll(pList); }
			List<String> mList = monsterObj.attack(player);
			if (mList != null) { msgList.addAll(mList); }
			if (monsterObj.getHp() > 0 && player.getHp() > 0) {
				request.setAttribute("monster", monster);
				msgList.add(player.getName() + ":" + player.getHp() + " " + monsterObj.getJaType() + ":" + monsterObj.getHp());
			}
		} else if (select.equals("run")) {
			msgList.addAll(player.run());
		}
		request.setAttribute("msgList", msgList);
		String url = "WEB-INF/jsp/main.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
