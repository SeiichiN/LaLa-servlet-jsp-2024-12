package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.FindEmpByIdLogic;
import servlet.util.SetEmployeeUtil;

import java.io.IOException;

@WebServlet(urlPatterns = {"/create", "/update", "/remove"})
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title_h2", "新規社員登録");
		request.setAttribute("input_jspfile", "create.jsp");
		String url = "WEB-INF/jsp/input/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		Employee employee = logic.execute(id);
		request.setAttribute("employee", employee);
		
		String path = request.getServletPath();
		String title_h2 = null;
		String input_jspfile = null;
		switch (path) {
		case "/update" -> {
			title_h2 = "社員情報更新";
			input_jspfile = "update.jsp";
		}
		case "/remove" -> {
			title_h2 = "社員情報削除";
			input_jspfile = "remove.jsp";
		}
		}
		request.setAttribute("title_h2", title_h2);
		request.setAttribute("input_jspfile", input_jspfile);
		String url = "WEB-INF/jsp/input/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);		
	}

}
