package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import servlet.util.SetEmployeeUtil;
import servlet.util.ValidateUtil;

@WebServlet(urlPatterns = {"/createConfirm", "/updateConfirm"})
public class ConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		SetEmployeeUtil setEmployeeUtil = new SetEmployeeUtil();
		Employee employee = setEmployeeUtil.set(request);
		ValidateUtil validateUtil = new ValidateUtil();
		List<String> errorMsgList = null;
		String title_h2 = null;
		String url = null;
		String input_jspfile = null;
		String confirm_jspfile = null;
		switch (path) {
		case "/createConfirm" -> {
			errorMsgList = validateUtil.createCheck(employee);
			title_h2 = "新規登録";
			input_jspfile = "create.jsp";
			confirm_jspfile = "createConfirm.jsp";
			
		}
		case "/updateConfirm" -> {
			errorMsgList = validateUtil.updateCheck(employee);
			title_h2 = "社員情報編集";
			input_jspfile = "update.jsp";
			confirm_jspfile = "updateConfirm.jsp";
		}
		}
		if (errorMsgList.size() > 0) {
			request.setAttribute("errorMsgList", errorMsgList);
			url = "WEB-INF/jsp/input/input.jsp";
			request.setAttribute("input_jspfile", input_jspfile);
		} else {
			url = "WEB-INF/jsp/confirm/confirm.jsp";
			request.setAttribute("confirm_jspfile", confirm_jspfile);
		}
		request.setAttribute("title_h2", title_h2);
		request.setAttribute("employee", employee);
		request.getRequestDispatcher(url).forward(request, response);
	}

}
