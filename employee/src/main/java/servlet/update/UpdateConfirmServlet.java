package servlet.update;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import util.GetParam;
import util.Validate;

@WebServlet("/updateConfirm")
public class UpdateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = GetParam.receive(request);
		System.out.println(emp);
		List<String> errMsgList = Validate.check(emp, "update");
		String url = null;
		if (errMsgList.size() > 0) {
			request.setAttribute("errMsgList", errMsgList);
			request.setAttribute("title", "社員情報更新");
			request.setAttribute("gotoUrl", "/updateConfirm");
			request.setAttribute("mode", "update");
			url = "/WEB-INF/jsp/editEmp.jsp";
		} else {
			request.setAttribute("title", "社員情報更新");
			request.setAttribute("gotoUrl", "/updateRegister");
			request.setAttribute("submitBtnLabel", "更新");
			request.setAttribute("fix_link", "/fix_update");
			url = "/WEB-INF/jsp/confirmEmp.jsp";
		}
		request.setAttribute("emp", emp);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
