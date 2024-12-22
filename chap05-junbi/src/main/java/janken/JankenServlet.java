package janken;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/janken")
public class JankenServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String hand = request.getParameter("hand");
		String result = null;
		int user = 0;
		int com = 0;
		if (hand.matches("^[012]$")) {
			user = Integer.parseInt(hand);
			com = (int)(Math.random() * 3);
			if ((user + 1) % 3 == com) {
				result = "あなたの勝ちです";
			} else if (user == com) {
				result = "あいこです";
			} else {
				result = "あなたの負けです";
			}
		} else {
			result = "入力ミスです > " + hand;
		}
		response.setContentType("text/html; charset=UTF-8");
		String[] hands = {"グー", "チョキ", "パー"};
		PrintWriter out = response.getWriter();
		out.println("<html><body><p>");
		out.println("あなた：" + hands[user] + " わたし：" + hands[com] + "<br>");
		out.println(result);
		out.println("</p><a href='janken.jsp'>もう一度<p>");
		out.println("</p></body></html>");
		
	}

}
