package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.CreateEmployeeLogic;
import model.DeleteEmployeeLogic;
import model.Employee;
import model.UpdateEmployeeLogic;
import model.interf.EmployeeLogic;
import util.GetParam;

@WebServlet(urlPatterns = {"/inputRegister", "/updateRegister", "/deleteDone"})
public class RegistEmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		// id, name, age を受け取る
		Employee emp = GetParam.receive(request);
		String msg = null;
		String word = null;
		EmployeeLogic logic = null;
		if (path.equals("/inputRegister")) {
			logic = new CreateEmployeeLogic();
			word = "登録";
		} else if (path.equals("/updateRegister")) {
			logic = new UpdateEmployeeLogic();
			word = "更新";
		} else if (path.equals("/deleteDone")) {
			logic = new DeleteEmployeeLogic();
			word = "削除";
		}
		if (logic.execute(emp)) {
			msg = word + "しました";
		} else {
			msg = word + "に失敗しました";
		}
		request.setAttribute("msg", msg);
		request.setAttribute("title", "社員" + word);
		
		String url = "/WEB-INF/jsp/workDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);

	}

}
