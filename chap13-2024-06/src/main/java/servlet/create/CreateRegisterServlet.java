package servlet.create;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.RegisterEmpLogic;
import servlet.util.GetParamUtil;

@WebServlet("/createRegister")
public class CreateRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetParamUtil util = new GetParamUtil();
		Employee emp = util.execute(request);
		RegisterEmpLogic logic = new RegisterEmpLogic();
		boolean result = logic.execute(emp);
		String msg = null;
		if (result) {
			msg = "登録しました";
		} else {
			msg = "登録に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/create/createDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
