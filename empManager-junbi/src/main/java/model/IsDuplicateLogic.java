package model;

import dao.EmployeesDAO;

public class IsDuplicateLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		if (dao.isDuplicate(id)) {
			return true;
		} 
		return false;
	}
}
