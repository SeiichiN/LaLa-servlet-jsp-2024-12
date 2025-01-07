package servlet;

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


@WebServlet(urlPatterns = {"/_inputConfirm", "/_updateConfirm"})
public class _ConfirmEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		Employee emp = GetParam.receive(request);
		System.out.println(emp);
		List<String> errMsgList = null;
		if (path.equals("/inputConfirm")) {
			errMsgList = Validate.check(emp, "create");
			request.setAttribute("title", "新規社員登録");
		}
		else if (path.equals("/updateConfirm")) {
			errMsgList = Validate.check(emp, "update");
			request.setAttribute("title", "社員情報更新");
		}
		String url = null;
		if (errMsgList.size() > 0) {
			request.setAttribute("errMsgList", errMsgList);
			if (path.equals("/inputConfirm")) {
				request.setAttribute("gotoUrl", "/inputConfirm");
				request.setAttribute("mode", "create");
			} else if (path.equals("/updateConfirm")) {
				request.setAttribute("gotoUrl", "/updateConfirm");
				request.setAttribute("mode", "update");
			}
			url = "/WEB-INF/jsp/editEmp.jsp";
		} else {
			if (path.equals("/inputConfirm")) {
				request.setAttribute("gotoUrl", "/inputRegister");
				request.setAttribute("submitBtnLabel", "登録");
			} else if (path.equals("/updateConfirm")) {
				request.setAttribute("gotoUrl", "/updateRegister");
				request.setAttribute("submitBtnLabel", "更新");
			}
			url = "/WEB-INF/jsp/confirmEmp.jsp";
		}
		request.setAttribute("emp", emp);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);

	}

}
