package servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
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
		
		switch (path) {
		case "/createDone" -> {
			SetEmployeeUtil util = new SetEmployeeUtil();
			Employee employee = util.set(request);
			PostEmpLogic logic = new PostEmpLogic();
			if (logic.execute(employee)) {
				msg = "登録しました";
			} else {
				msg = "登録に失敗しました";
			}
		}
		case "/updateDone" -> {
			SetEmployeeUtil util = new SetEmployeeUtil();
			Employee employee = util.set(request);
			UpdateEmpLogic logic = new UpdateEmpLogic();
			if (logic.execute(employee)) {
				msg = "更新しました";
			} else {
				msg = "更新に失敗しました";
			}			
		}
		case "/removeDone" -> {
			String id = request.getParameter("id");
			RemoveByIdLogic logic = new RemoveByIdLogic();
		   if (logic.execute(id)) {
			   msg = "削除しました。";
		   } else {
			   msg = "削除に失敗しました。";
		   }
			
		}
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/done/done.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
