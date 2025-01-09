package servlet.create;

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

@WebServlet("/CreateConfirmServlet")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetEmployeeUtil setEmployeeUtil = new SetEmployeeUtil();
		Employee emp = setEmployeeUtil.set(request);
		ValidateUtil validateUtil = new ValidateUtil();
		List<String> errorMsgList = validateUtil.check(emp);
		request.setAttribute("employee", emp);
		String url = null;
		if (errorMsgList.size() > 0) {
			request.setAttribute("errorMsgList", errorMsgList);
			url = "WEB-INF/jsp/create/createEmp.jsp";
		} else {
			url = "WEB-INF/jsp/create/createConfirm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
