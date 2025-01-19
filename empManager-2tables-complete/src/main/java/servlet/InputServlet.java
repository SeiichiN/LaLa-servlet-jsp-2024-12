package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.FindEmpByIdLogic;
import servlet.util.SetEmployeeUtil;

import java.io.IOException;

import bean.Employee;
import bean.EmployeeForm;

@WebServlet(urlPatterns = {"/createInput", "/updateInput", "/removeInput"})
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("title_h2", "新規社員登録");
		request.setAttribute("input_form", "_createInput.jsp");
		String url = "WEB-INF/jsp/input/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String _empId = request.getParameter("empId");
		int empId = Integer.parseInt(_empId);
		FindEmpByIdLogic logic = new FindEmpByIdLogic();
		Employee employee = logic.execute(empId);
		EmployeeForm employeeForm = convertForm(employee);
		request.setAttribute("employeeForm", employeeForm);
		
		String path = request.getServletPath();
		String title_h2 = null;
		String input_form = null;
		switch (path) {
		case "/updateInput" -> {
			title_h2 = "社員情報更新";
			input_form = "_updateInput.jsp";
		}
		case "/removeInput" -> {
			title_h2 = "社員情報削除";
			input_form = "_removeInput.jsp";
		}
		}
		request.setAttribute("title_h2", title_h2);
		request.setAttribute("input_form", input_form);
		String url = "WEB-INF/jsp/input/input.jsp";
		request.getRequestDispatcher(url).forward(request, response);		
	}
	
	private EmployeeForm convertForm(Employee emp) {
		int id = emp.getId();
		String name = emp.getName();
		int gender = emp.getGender();
		String birthday = emp.getBirthday();
		int deptId = emp.getDept().getId();
		return new EmployeeForm(id, name, gender, birthday, deptId);
	}

}
