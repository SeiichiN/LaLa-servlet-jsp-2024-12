package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import bean.Dept;
import bean.Employee;
import model.FindAllLogic;
import model.dept.FindDeptListLogic;

@WebServlet("/list")
public class GetListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		FindDeptListLogic deptLogic = new FindDeptListLogic();
		List<Dept> deptList = deptLogic.execute();
		session.setAttribute("deptList", deptList);
		
		FindAllLogic empLogic = new FindAllLogic();
		List<Employee> empList = empLogic.execute();
		request.setAttribute("empList", empList);
		String url = "WEB-INF/jsp/find/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);		
	}

}
