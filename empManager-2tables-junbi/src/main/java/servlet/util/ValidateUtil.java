package servlet.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

import bean.EmployeeForm;
import model.dept.IsExistsIdLogic;
import util.MyUtil;

public class ValidateUtil {
	private List<String> errorMsgList = new ArrayList<>();

	public List<String> check(EmployeeForm empForm) {
		nameCheck(empForm);
		genderCheck(empForm);
		birthdayCheck(empForm);
		deptIdCheck(empForm);
		return errorMsgList;
	}
		
	private void nameCheck(EmployeeForm empForm) {
		if (isNull(empForm.getName())) {
			errorMsgList.add("名前が未入力です");
		} else if (empForm.getName().length() > 20) {
			errorMsgList.add("名前が長すぎます");
		}
	}

	private void genderCheck(EmployeeForm empForm) {
		if (empForm.getGender() < 1 || empForm.getGender() > 3) {
			errorMsgList.add("性別が不正です");
		}
	}
	
	private void birthdayCheck(EmployeeForm empForm) {
		if (!MyUtil.isDate(empForm.getBirthday())) {
			errorMsgList.add("誕生日の日付が不正です");
		}
	}
	
	private void deptIdCheck(EmployeeForm empForm) {
		IsExistsIdLogic logic = new IsExistsIdLogic();
		int id = empForm.getDeptId();
		if (!logic.execute(id)) {
			errorMsgList.add("その部署は存在しません");
		}
	}
	
	private boolean isNull(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
	
}
