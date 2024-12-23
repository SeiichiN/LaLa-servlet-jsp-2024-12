package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import beans.Hero;
import beans.Matango;
import main.SerializableRW;

@WebServlet("/write")
public class WriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Hero hero = new Hero("タロウ");
		SerializableRW.saveObj("hero.ser", hero);
		
		Matango m = new Matango('C');
		m.setHp(50);
		SerializableRW.saveObj("matango.ser", m);
	}

}
