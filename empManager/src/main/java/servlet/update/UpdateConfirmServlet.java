package servlet.update;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import servlet.util.SetEmployeeUtil;
import servlet.util.ValidateUtil;

@WebServlet("/UpdateConfirmServlet")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetEmployeeUtil util = new SetEmployeeUtil();
		Employee employee = util.set(request);
		ValidateUtil validateUtil = new ValidateUtil();
		List<String> errorMsgList = validateUtil.check(employee, "update");
		
		String url = null;
		if (errorMsgList.size() > 0) {
			request.setAttribute("errorMsgList", errorMsgList);
			url = "WEB-INF/jsp/update/updateEmp.jsp";
		} else {
			url = "WEB-INF/jsp/update/updateConfirm.jsp";
		}
		request.setAttribute("employee", employee);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
