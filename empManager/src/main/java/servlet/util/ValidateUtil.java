package servlet.util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsDuplicateIdLogic;

public class ValidateUtil {
	public List<String> check(Employee emp, String mode) {
		List<String> errorMsgList = new ArrayList<>();
		// id check
		if (mode.equals("create")) {
			IsDuplicateIdLogic logic = new IsDuplicateIdLogic();
			if (isNull(emp.getId())) {
				errorMsgList.add("IDが未入力です");
			} else if (!emp.getId().matches("^EMP[0-9]{3}$")) {
				errorMsgList.add("IDの形式が不正です");
			} else if (logic.execute(emp.getId())) {
				errorMsgList.add("そのIDは使えません");
			}
		}
		
		// name check
		if (isNull(emp.getName())) {
			errorMsgList.add("名前が未入力です");
		} else if (emp.getName().length() > 20) {
			errorMsgList.add("名前が長すぎます");
		}
		
		// age check
		if (emp.getAge() < 18 || emp.getAge() > 80) {
			errorMsgList.add("年齢が不正です");
		}
		
		return errorMsgList;
	}
	
	private boolean isNull(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}
