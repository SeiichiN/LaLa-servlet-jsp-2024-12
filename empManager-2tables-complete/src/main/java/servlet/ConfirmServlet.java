package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.EmployeeForm;
import servlet.util.SetEmployeeUtil;
import servlet.util.ValidateUtil;

@WebServlet(urlPatterns = {"/createConfirm", "/updateConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		SetEmployeeUtil setEmployeeUtil = new SetEmployeeUtil();
		EmployeeForm employeeForm = setEmployeeUtil.set(request);
		ValidateUtil validateUtil = new ValidateUtil();
		List<String> errorMsgList = validateUtil.check(employeeForm); 
		String title_h2 = null;
		String url = null;
		String input_form = null;
		String confirm_form = null;
		switch (path) {
		case "/createConfirm" -> {
			title_h2 = "新規登録";
			input_form = "_createInput.jsp";
			confirm_form = "_createConfirm.jsp";
			
		}
		case "/updateConfirm" -> {
			title_h2 = "社員情報編集";
			input_form = "_updateInput.jsp";
			confirm_form = "_updateConfirm.jsp";
		}
		}
		if (errorMsgList.size() > 0) {
			request.setAttribute("errorMsgList", errorMsgList);
			url = "WEB-INF/jsp/input/input.jsp";
			request.setAttribute("input_form", input_form);
		} else {
			url = "WEB-INF/jsp/confirm/confirm.jsp";
			request.setAttribute("confirm_form", confirm_form);
		}
		request.setAttribute("title_h2", title_h2);
		request.setAttribute("employeeForm", employeeForm);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
