package servlet.util;

import jakarta.servlet.http.HttpServletRequest;

import bean.EmployeeForm;

public class SetEmployeeUtil {
	public EmployeeForm set(HttpServletRequest request) {
		// String id = request.getParameter("id");
		// id = id.replace("　", " ").trim().toUpperCase();
		// id = toHankaku(id);
		int id = 0;
		
		String name = request.getParameter("name");
		name = name.replace("　", " ").trim();
		
		String _gender = request.getParameter("gender");
		_gender = _gender.replace("　", " ").trim();
		int gender = myParseInt(_gender);
		
		String birthday = request.getParameter("birthday");
		birthday = birthday.replace("　", " ").trim();
		birthday = formatDate(birthday);
		
		String _deptId = request.getParameter("deptId");
		_deptId = _deptId.replace("　", " ").trim();
		int deptId = myParseInt(_deptId);
		
		EmployeeForm employeeForm = new EmployeeForm(id, name, gender, birthday, deptId);
		return employeeForm;
	}
	
	private String formatDate(String dateTxt) {
		if (!dateTxt.matches("^[0-9]{4}/[0-9]{1,2}/[0-9]{1,2}$")) {
			return dateTxt;
		}
		String[] data = dateTxt.split("/");
		String year = data[0];
		String month = "0" + data[1];
		month = month.substring(month.length() - 2);
		String day = "0" + data[2];
		day = day.substring(day.length() - 2);
		return year + "/" + month + "/" + day;		
	}
	
	private int myParseInt(String numTxt) {
		int num = 0;
		try {
			num = Integer.parseInt(numTxt);
		} catch (NumberFormatException e) {
			num = -1;
		}
		return num;
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
