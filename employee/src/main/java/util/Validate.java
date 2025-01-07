package util;

import java.util.ArrayList;
import java.util.List;

import model.Employee;
import model.IsExistsIdLogic;

public class Validate {
	public static List<String> check(Employee emp, String mode) {
		List<String> errMsgList = new ArrayList<>();
		
		// id check
		if (isNull(emp.getId())) {
			errMsgList.add(Messages.ID_NULL_ERR);
		}
		else if (emp.getId().length() != Const.ID_LENGTH) {
			errMsgList.add(Messages.ID_LENGTH_ERR);
		}
		else if (! emp.getId().matches(Const.ID_PATTERN)) {
			errMsgList.add(Messages.ID_FORM_ERR);
		}
		else if (mode.equals("create") && isExistsId(emp.getId())) {
			errMsgList.add(Messages.ID_EXISTS_ERR);
		}
		
		// name check
		if (isNull(emp.getName())) {
			errMsgList.add(Messages.NAME_NULL_ERR);
		}
		else if (emp.getName().length() > Const.NAME_LENGTH) {
			errMsgList.add(Messages.NAME_LENGTH_ERR);
		}
		
		// age check
		if (emp.getAge() < Const.AGE_MIN || emp.getAge() > Const.AGE_MAX) {
			errMsgList.add(Messages.AGE_RANGE_ERR);
		}
		
		return errMsgList;
	}
	
	/**
	 * ヌルであるか空文字であるか
	 * @param s 文字列
	 * @return true ヌル、もしくは空文字<br>
	 *         false ヌル・空文字ではない
	 */
	private static boolean isNull(String s) {
		if (s == null || s.length() == 0) {
			return true;
		}
		return false;
	}
	
	/**
	 * IDが存在するかをチェック
	 * @param id 文字列
	 * @return true その ID はすでに使われている
	 *         false その ID は未使用である
	 */
	private static boolean isExistsId(String id) {
		IsExistsIdLogic logic = new IsExistsIdLogic();
		return logic.execute(id);
	}
}
