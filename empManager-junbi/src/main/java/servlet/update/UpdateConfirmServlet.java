package servlet.update;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import util.SetEmployee;
import util.Validate;

@WebServlet("/UpdateConfirmServlet")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetEmployee setEmployee = new SetEmployee();
		Employee employee = setEmployee.set(request);
		System.out.println(employee);
		Validate validate = new Validate();
		List<String> errorMsgList = validate.check(employee, "update");
		request.setAttribute("employee", employee);
		String url = null;
		if (errorMsgList.size() > 0) {
			request.setAttribute("errorMsgList", errorMsgList);
			url = "WEB-INF/jsp/update/updateEmp.jsp";
		} else {
			url = "WEB-INF/jsp/update/updateConfirm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
