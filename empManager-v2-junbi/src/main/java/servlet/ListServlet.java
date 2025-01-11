package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.GetListLogic;

@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetListLogic getListLogic = new GetListLogic();
		List<Employee> empList = getListLogic.execute();
		request.setAttribute("empList", empList);
		String url = "WEB-INF/jsp/find/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
