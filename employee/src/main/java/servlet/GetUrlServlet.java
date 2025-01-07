package servlet;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.GetEmployeeByIdLogic;
import util.GetParam;

@WebServlet(urlPatterns = 
  {"/input", "/update", "/delete", "/fix_input", "/fix_update"})
public class GetUrlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		setReq(request);
		String url = "/WEB-INF/jsp/editEmp.jsp";
		RequestDispatcher dispatcher =
				request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}
	
	private void setReq(HttpServletRequest request) {
		request.setAttribute("title", "新規社員登録");
		request.setAttribute("gotoUrl", "/inputConfirm");
		request.setAttribute("mode", "create");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		Employee emp = null;
		if (path.equals("/fix_input") || path.equals("/fix_update")) {
			emp = GetParam.receive(request);
		} else {
			String id = request.getParameter("id");
			GetEmployeeByIdLogic logic = new GetEmployeeByIdLogic();
			emp = logic.execute(id);
			System.out.println(emp);
		}
		request.setAttribute("emp", emp);
		
		String url = null;
		if (path.equals("/update") || path.equals("/fix_update")) {
			request.setAttribute("title", "社員情報更新");
			request.setAttribute("gotoUrl", "/updateConfirm");
			request.setAttribute("mode", "update");
			url = "/WEB-INF/jsp/editEmp.jsp";
		} else if (path.equals("/delete")) {
			request.setAttribute("title", "社員情報削除");
			request.setAttribute("gotoUrl", "/deleteDone");
			request.setAttribute("submitBtnLabel", "削除");
			request.setAttribute("mode", "delete");
			url = "/WEB-INF/jsp/confirmEmp.jsp";
		} else if (path.equals("/fix_input")) {
			setReq(request);
			url = "/WEB-INF/jsp/editEmp.jsp";
		}
		request.getRequestDispatcher(url)
		       .forward(request, response);
	}

}
