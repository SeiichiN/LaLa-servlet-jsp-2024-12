package servlet.remove;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.RemoveEmpLogic;

@WebServlet("/RemoveDoneServlet")
public class RemoveDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RemoveEmpLogic logic = new RemoveEmpLogic();
		String msg = null;
		if (logic.execute(id)) {
			msg = "削除しました";
		} else {
			msg = "削除に失敗しました";
		}
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/remove/removeDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
