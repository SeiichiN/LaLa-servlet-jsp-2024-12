package servlet;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Employee;
import model.GetListLogic;

<<<<<<<< HEAD:chap13-2024-06/src/main/java/servlet/GetListServlet.java
@WebServlet("/getList")
public class GetListServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GetListLogic logic = new GetListLogic();
		List<Employee> empList = logic.execute();
		request.setAttribute("empList", empList);
		String url = "WEB-INF/jsp/find/empList.jsp";
========
@WebServlet(urlPatterns = {"/createInput"})
public class InputServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "WEB-INF/jsp/input/input.jsp";
>>>>>>>> main:empManager_2tables/src/main/java/servlet/InputServlet.java
		request.getRequestDispatcher(url).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
