package servlet.create;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model.Employee;
import servlet.util.CheckEmpUtil;
import servlet.util.GetParamUtil;

@WebServlet("/createConfirm")
public class CreateConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<String> errorList = new ArrayList<>();
		GetParamUtil util = new GetParamUtil();
		Employee emp = util.execute(request);
		// System.out.println(emp);
		
		CheckEmpUtil checkEmpUtil = new CheckEmpUtil();
		checkEmpUtil.execute(emp, errorList);
		request.setAttribute("emp", emp);
		String url = null;
		if (errorList.size() > 0) {
			request.setAttribute("errorList", errorList);
			url = "WEB-INF/jsp/create/createEmp.jsp";
		} else if (errorList.size() == 0) {
			url = "WEB-INF/jsp/create/createConfirm.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}

}
