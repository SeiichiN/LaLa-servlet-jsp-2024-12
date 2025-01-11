package servlet.util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsDuplicateIdLogic;

public class ValidateUtil {
	private List<String> errorMsgList = new ArrayList<>();

	public List<String> createCheck(Employee emp) {
		idCheck(emp);
		nameCheck(emp);
		ageCheck(emp);
		return errorMsgList;
	}
	
	public List<String> updateCheck(Employee emp) {
		nameCheck(emp);
		ageCheck(emp);
		return errorMsgList;
	}
	
	private void idCheck(Employee emp) {
		IsDuplicateIdLogic logic = new IsDuplicateIdLogic();
		if (isNull(emp.getId())) {
			errorMsgList.add("IDが未入力です");
		} else if (!emp.getId().matches("^EMP[0-9]{3}$")) {
			errorMsgList.add("IDの形式が不正です");
		} else if (logic.execute(emp.getId())) {
			errorMsgList.add("そのIDは使えません");
		}
	}
	
	private void nameCheck(Employee emp) {
		if (isNull(emp.getName())) {
			errorMsgList.add("名前が未入力です");
		} else if (emp.getName().length() > 20) {
			errorMsgList.add("名前が長すぎます");
		}
	}
	
	private void ageCheck(Employee emp) {
		if (emp.getAge() < 18 || emp.getAge() > 80) {
			errorMsgList.add("年齢が不正です");
		}
	}
	
	private boolean isNull(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}
