package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FindEmpByDeptIdLogic;
import model.FindEmpByNameLogic;
import util.MyUtil;

import java.io.IOException;
import java.util.List;

import bean.Employee;

@WebServlet(urlPatterns = {"/findByName", "/findByDeptId"})
public class FindServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		List<Employee> empList = null;
		switch (path) {
			case "/findByName" -> {
				String name = request.getParameter("name");
				FindEmpByNameLogic findEmpByNameLogic = new FindEmpByNameLogic();
				empList = findEmpByNameLogic.execute(name);
			}
			case "/findByDeptId" -> {
				String _deptId = request.getParameter("deptId");
				int deptId = MyUtil.myParseInt(_deptId);
				FindEmpByDeptIdLogic findEmpByDeptIdLogic = new FindEmpByDeptIdLogic();
				empList = findEmpByDeptIdLogic.execute(deptId);
			}
		}
		request.setAttribute("empList", empList);
		String url = "WEB-INF/jsp/find/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
