package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.EmployeeForm;
import model.PostEmpLogic;
import model.RemoveByIdLogic;
import model.UpdateEmpLogic;
import servlet.util.SetEmployeeUtil;

@WebServlet(urlPatterns = {"/createDone", "/updateDone", "/removeDone"})
public class DoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String path = request.getServletPath();
		String msg = null;
		String title_h2 = null;
		
		switch (path) {
		case "/createDone" -> {
			SetEmployeeUtil util = new SetEmployeeUtil();
			EmployeeForm employeeForm = util.set(request);
			PostEmpLogic logic = new PostEmpLogic();
			if (logic.execute(employeeForm)) {
				msg = "登録しました";
			} else {
				msg = "登録に失敗しました";
			}
			title_h2 = "新規登録";
		}
		case "/updateDone" -> {
			SetEmployeeUtil util = new SetEmployeeUtil();
			EmployeeForm employeeForm = util.set(request);
			UpdateEmpLogic logic = new UpdateEmpLogic();
			if (logic.execute(employeeForm)) {
				msg = "更新しました";
			} else {
				msg = "更新に失敗しました";
			}
			title_h2 = "社員情報更新";
		}
		case "/removeDone" -> {
			String id = request.getParameter("id");
			RemoveByIdLogic logic = new RemoveByIdLogic();
		   if (logic.execute(id)) {
			   msg = "削除しました。";
		   } else {
			   msg = "削除に失敗しました。";
		   }
			title_h2 = "社員情報削除";
		}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("title_h2", title_h2);
		String url = "WEB-INF/jsp/done/done.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
