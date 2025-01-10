package servlet.find;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import model.FindEmpListByNameLogic;

@WebServlet("/SearchNameServlet")
public class SearchNameServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		name = name.replace("　", " ").trim();
		List<String> errorMsgList = paramCheck(name);
		if (errorMsgList.size() > 0) {
			request.setAttribute("errorMsgList", errorMsgList);
		} else {
			FindEmpListByNameLogic logic = new FindEmpListByNameLogic();
			List<Employee> empList = logic.execute(name);
			request.setAttribute("empList", empList);
		}
		String url = "WEB-INF/jsp/find/empList.jsp";
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	private List<String> paramCheck(String param) {
		List<String> errorMsgList = new ArrayList<>();
		if (param == null || param.length() == 0) {
			errorMsgList.add("未入力です");
		}
		if (param.length() > 10) {
			errorMsgList.add("文字が長すぎます");
		}
		return errorMsgList;
	}

}
