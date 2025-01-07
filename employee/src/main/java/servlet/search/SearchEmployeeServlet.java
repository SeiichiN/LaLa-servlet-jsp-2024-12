package servlet.search;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.FindEmployeeByNameLogic;

@WebServlet("/search")
public class SearchEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		System.out.println("name:" + name);
		
		FindEmployeeByNameLogic logic = new FindEmployeeByNameLogic();
		List<Employee> empList = logic.execute(name);
		request.setAttribute("empList", empList);
		request.setAttribute("mode", "search");
		
		String url = "/WEB-INF/jsp/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
