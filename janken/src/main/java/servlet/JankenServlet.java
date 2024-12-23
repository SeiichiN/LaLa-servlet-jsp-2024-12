package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/poi")
public class JankenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hand = request.getParameter("hand");
		if (!hand.matches("^[012]$")) {
			System.out.println("不正な操作です");
			return;
		}
		int user = Integer.parseInt(hand);
		int com = (int)(Math.random() * 3);
		String result = null;
		if (user == com) {
			result = "あいこ";
		} else if ((user + 1) % 3 == com) {
			result = "userの勝ち";
		} else {
			result = "comの勝ち";
		}
		String[] hands = {"グー", "チョキ", "パー"};
		String result2 = "user:" + hands[user] + " com:" + hands[com];
		
		request.setAttribute("result", result);
		request.setAttribute("result2", result2);
		
		String url = "WEB-INF/jsp/result.jsp";
		RequestDispatcher d =
				request.getRequestDispatcher(url);
		d.forward(request, response);
		
	}

}
