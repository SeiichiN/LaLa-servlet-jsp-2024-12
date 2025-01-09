package servlet.remove;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetEmpByIdLogic;
import model.UpdateEmpLogic;
import util.SetEmployee;

@WebServlet("/RemoveConfirmServlet")
public class RemoveConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		GetEmpByIdLogic logic = new GetEmpByIdLogic();
		Employee employee = logic.execute(id);
		request.setAttribute("employee", employee);
		String url = "WEB-INF/jsp/remove/removeConfirm.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
