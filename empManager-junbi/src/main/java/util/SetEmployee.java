package util;

import jakarta.servlet.http.HttpServletRequest;
import model.Employee;

public class SetEmployee {
	public Employee set(HttpServletRequest request) {
		String id = request.getParameter("id").trim();
		id = toHankaku(id);
		id = id.toUpperCase();
		String name = request.getParameter("name").trim();
		name = name.replace("　", " ");
		String ageTxt = request.getParameter("age").trim();
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt);
		} catch (NumberFormatException e) {
			age = -1;
		}
		Employee emp = new Employee(id, name, age);
		return emp;
	}
	
	private static String toHankaku(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			int c = (int) sb.charAt(i);
			if ((c >= 0xFF10 && c <= 0xFF19) || 
				(c >= 0xFF21 && c <= 0xFF3A) || 
				(c >= 0xFF41 && c <= 0xFF5A)) {
				sb.setCharAt(i, (char) (c - 0xFEE0));
			}
		}
		str = sb.toString();
		return str;
	}
	
}
