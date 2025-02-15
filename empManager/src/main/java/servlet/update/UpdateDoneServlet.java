package servlet.update;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.UpdateEmpLogic;
import servlet.util.SetEmployeeUtil;

@WebServlet("/UpdateDoneServlet")
public class UpdateDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		SetEmployeeUtil util = new SetEmployeeUtil();
		Employee employee = util.set(request);
		UpdateEmpLogic logic = new UpdateEmpLogic();
		String msg = null;
		if (logic.execute(employee)) {
			msg = "更新しました";
		} else {
			msg = "更新に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/update/updateDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
