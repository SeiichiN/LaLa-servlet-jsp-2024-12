package servlet.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeForm;
import model.dept.IsExistsDeptIdLogic;

public class ValidateUtil {
	public List<String> check(EmployeeForm empForm) {
		List<String> errorMsgList = new ArrayList<>();
		
		// name check
		if (isNull(empForm.getName())) {
			errorMsgList.add("名前が未入力です");
		} else if (empForm.getName().length() > 20) {
			errorMsgList.add("名前が長すぎます");
		}
		// gender check
		if (empForm.getGender() < 1 || empForm.getGender() > 2) {
			errorMsgList.add("性別が不正です");
		}
		// birthday check
		if (!isDate(empForm.getBirthday())) {
			errorMsgList.add("誕生日の日付が不正です");
		}
		// deptId check
		IsExistsDeptIdLogic logic = new IsExistsDeptIdLogic();
		if (!logic.execture(empForm.getDeptId())) {
			errorMsgList.add("その部署は存在しません");
		}
		
		return errorMsgList;
	}
	
	// true -- 正しい日付
	private boolean isDate(String dateTxt) {		
		String pattern = "yyyy/MM/dd";
		try {
			LocalDate.parse(dateTxt, DateTimeFormatter.ofPattern(pattern));
		} catch (DateTimeParseException e) {
			return false;
		}
		return true;
	}
	
	private boolean isNull(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}
