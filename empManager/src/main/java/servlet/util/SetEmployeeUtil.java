package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import model.Employee;

public class SetEmployeeUtil {
	public Employee set(HttpServletRequest request) {
		String id = request.getParameter("id");
		id = id.replace("　", " ").trim().toUpperCase();
		id = toHankaku(id);
		
		String name = request.getParameter("name");
		name = name.replace("　", " ").trim();
		
		String ageTxt = request.getParameter("age");
		ageTxt = ageTxt.replace("　", " ").trim();
		int age = 0;
		try {
			age = Integer.parseInt(ageTxt);
		} catch (NumberFormatException e) {
			age = -1;
		}
		Employee employee = new Employee(id, name, age);
		return employee;
	}
	
	public String toHankaku(String str) {
		StringBuilder sb = new StringBuilder(str);
		for (int i = 0; i < sb.length(); i++) {
			int c = (int) sb.charAt(i);
			if ((c >= 0xFF10 && c <= 0xFF19) ||       // �O�`�X
				(c >= 0xFF21 && c <= 0xFF3A) ||         // �`�`�y
				(c >= 0xFF41 && c <= 0xFF5A)) {         // ���`��
				sb.setCharAt(i, (char) (c - 0xFEE0));
			}
		}
		str = sb.toString();
		return str;
	}
}
