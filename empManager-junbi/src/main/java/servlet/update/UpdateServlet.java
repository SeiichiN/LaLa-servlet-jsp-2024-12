package servlet.update;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.GetEmpByIdLogic;

import java.io.IOException;

@WebServlet("/UpdateServlet")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		GetEmpByIdLogic logic = new GetEmpByIdLogic();
		Employee emp = logic.execute(id);
		request.setAttribute("emp", emp);
		String url = "WEB-INF/jsp/update/updateEmp.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
