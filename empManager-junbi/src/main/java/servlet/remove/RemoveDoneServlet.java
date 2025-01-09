package servlet.remove;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.GetEmpByIdLogic;
import model.RemoveByIdLogic;
import util.SetEmployee;

import java.io.IOException;

@WebServlet("/RemoveDoneServlet")
public class RemoveDoneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		RemoveByIdLogic logic = new RemoveByIdLogic();
		String msg = null;
	   if (logic.execute(id)) {
		   msg = "削除しました。";
	   } else {
		   msg = "削除に失敗しました。";
	   }
		request.setAttribute("msg", msg);
		String url = "WEB-INF/jsp/remove/removeDone.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}

}
