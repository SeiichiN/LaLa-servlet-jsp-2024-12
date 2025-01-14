package servlet.remove;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpByIdLogic;

@WebServlet("/RemoveServlet")
public class RemoveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		Employee employee = logic.execute(id);
		
		request.setAttribute("employee", employee);
		String url = "WEB-INF/jsp/remove/removeEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
