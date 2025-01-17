package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.EmployeeForm;
import servlet.util.SetEmployeeUtil;
import servlet.util.ValidateUtil;

@WebServlet(urlPatterns = {"/createConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetEmployeeUtil util = new SetEmployeeUtil();
		EmployeeForm employeeForm = util.set(request);
		ValidateUtil validateUtil = new ValidateUtil();
		List<String> errorMsgList = validateUtil.check(employeeForm);
		
		String url = null;
		if (errorMsgList.size() > 0) {
			request.setAttribute("errorMsgList", errorMsgList);
			url = "WEB-INF/jsp/input/input.jsp";
			request.setAttribute("title_h2", "新規社員登録");
			request.setAttribute("input_form", "_createForm.jsp");
		} else {
			request.setAttribute("title_h2", "新規社員登録・確認");
			request.setAttribute("confirm_form", "_createConfirmForm.jsp");
			url = "WEB-INF/jsp/confirm/confirm.jsp";
		}
		request.setAttribute("employeeForm", employeeForm);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
