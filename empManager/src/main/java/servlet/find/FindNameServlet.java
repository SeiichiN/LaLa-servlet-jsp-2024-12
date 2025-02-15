package servlet.find;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpByNameLogic;

@WebServlet("/FindNameServlet")
public class FindNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		FindEmpByNameLogic logic = new FindEmpByNameLogic();
		List<Employee> empList = logic.execute(name);
		if (empList.size() == 0) {
			request.setAttribute("msg", "データがありません");
		}
		request.setAttribute("empList", empList);
		String url = "WEB-INF/jsp/find/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
