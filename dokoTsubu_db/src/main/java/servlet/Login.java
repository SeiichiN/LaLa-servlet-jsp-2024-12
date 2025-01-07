package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import model.LoginLogic;
import model.User;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// name,passを受け取る
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		
		// Userビーンズを作成
		User user = new User(name, pass);
		
		// LoginLogicインスタンスを作成
		LoginLogic loginLogic = new LoginLogic();
		
		// ログイン判定
		boolean isLogin = loginLogic.execute(user);
		
		// trueならセッションにUserを保存
		if (isLogin) {
			HttpSession session = request.getSession();
			session.setAttribute("loginUser", user);
		}
		
		// loginResult.jspにフォワード
		String url = "WEB-INF/jsp/loginResult.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
