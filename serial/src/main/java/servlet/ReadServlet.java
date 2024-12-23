package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Hero;
import beans.Matango;
import main.SerializableRW;

@WebServlet("/read")
public class ReadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hero hero = (Hero) SerializableRW.readObj("hero.obj");
		Matango m = (Matango) SerializableRW.readObj("matango.obj");
		List<String> msgList_a = hero.attack(m);
		List<String> msgList_b = m.attack(hero);
		request.setAttribute("msgList_a", msgList_a);
		request.setAttribute("msgList_b", msgList_b);
		request.getRequestDispatcher("main.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
