package servlet.util;

import java.util.List;

import model.Employee;
import model.GetEmpByIdLogic;

public class CheckEmpUtil {
	private final int NAME_LENGTH = 20;
	
	public void execute(Employee emp, 
			             List<String> errorList) {
		// id-check
		if (isNull(emp.getId())) {
			errorList.add("IDが未入力です");
		}
		else if (!emp.getId().matches("^EMP[0-9]{3}$")) {
			errorList.add("IDの形式が違います");
		}
		else {
			GetEmpByIdLogic logic = new GetEmpByIdLogic();
			Employee empl = logic.execute(emp.getId());
			if (empl != null) {
				errorList.add("そのIDは使えません");
			}
		}
		// name-check
		if (isNull(emp.getName())) {
			errorList.add("名前が未入力です");
		} 
		else if (emp.getName().length() > NAME_LENGTH) {
			errorList.add("名前が長すぎます");
		}
		// age-check
		if (emp.getAge() == 0) {
			errorList.add("年齢が未入力もしくは不正です");
		}
		
	}
	
	private boolean isNull(String str) {
		if (str == null || str.length() == 0) {
			return true;
		}
		return false;
	}
}
