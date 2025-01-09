package model;

import dao.EmployeesDAO;

public class IsDuplicateIdLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.isExists(id);
		
	}
}
