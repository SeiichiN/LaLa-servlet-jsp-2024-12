package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsDuplicateLogic;

public class Validate {
	public List<String> check(Employee emp, String path) {
		List<String> errorMsgList = new ArrayList<>();
		if (path.equals("/CreateConfirmServlet")) {
			IsDuplicateLogic isDuplicateLogic = new IsDuplicateLogic();
			if (isNull(emp.getId())) {
				errorMsgList.add("IDが未入力です");
			} else if (!emp.getId().matches("^EMP[0-9]{3}$")) {
				errorMsgList.add("IDの形式が不正です");
			} else if (isDuplicateLogic.execute(emp.getId())) {
				errorMsgList.add("そのIDは使えません");
			}
		}
		if (isNull(emp.getName())) {
			errorMsgList.add("名前が未入力です");
		} else if (emp.getName().length() > 20) {
			errorMsgList.add("名前が長すぎます");
		}
		if (emp.getAge() < 20 || emp.getAge() > 70) {
			errorMsgList.add("年齢が不正です");
		}
		return errorMsgList;
	}
	
	private boolean isNull(String param) {
		if (param == null || param.length() == 0) {
			return true;
		}
		return false;
	}
}
