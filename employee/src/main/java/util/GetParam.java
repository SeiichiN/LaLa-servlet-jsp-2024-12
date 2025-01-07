package util;

import jakarta.servlet.http.HttpServletRequest;
import model.Employee;

public class GetParam {
	public static Employee receive(HttpServletRequest request) {
		String id = request.getParameter("id").toUpperCase();
		String name = request.getParameter("name");
		int age = Tool.myParseInt(request.getParameter("age"));
		Employee emp = new Employee(id, name, age);
		return emp;
	}
}
