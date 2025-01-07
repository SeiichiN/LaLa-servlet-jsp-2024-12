package servlet.create;

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

@WebServlet("/inputConfirm")
public class InputConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee emp = GetParam.receive(request);
		System.out.println(emp);
		List<String> errMsgList = Validate.check(emp, "create");
		String url = null;
		if (errMsgList.size() > 0) {
			request.setAttribute("errMsgList", errMsgList);
			request.setAttribute("title", "新規社員登録");
			request.setAttribute("gotoUrl", "/inputConfirm");
			request.setAttribute("mode", "create");
			url = "/WEB-INF/jsp/editEmp.jsp";
		} else {
			request.setAttribute("errMsgList", errMsgList);
			request.setAttribute("title", "新規社員登録");
			request.setAttribute("gotoUrl", "/inputRegister");
			request.setAttribute("submitBtnLabel", "登録");
			request.setAttribute("fix_link", "/fix_input");
			url = "/WEB-INF/jsp/confirmEmp.jsp";
		}
		request.setAttribute("emp", emp);
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

}
