package servlet.util;

import java.util.List;

import jakarta.servlet.http.HttpServletRequest;

import model.Employee;

public class GetParamUtil {
	
	public Employee execute(HttpServletRequest request) {
		String id = request.getParameter("id").replace("　", " ").trim().toUpperCase();
		id = ZenHanUtil.execute(id);
		String name = request.getParameter("name").replace("　", " ").trim();
		String ageTxt = request.getParameter("age").replace("　", " ").trim();
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt);
		} catch (NumberFormatException e) {
			age = 0;
		}
		Employee emp = new Employee(id, name, age);
		return emp;
	}

//	public Employee execute(HttpServletRequest request) {
//		String id = request.getParameter("id");
//		String name = request.getParameter("name");
//		int age = Integer.parseInt(request.getParameter("age"));
//		Employee emp = new Employee(id, name, age);
//		return emp;
//	}
}
