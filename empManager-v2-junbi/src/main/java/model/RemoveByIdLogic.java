package model;

import dao.EmployeesDAO;

public class RemoveByIdLogic {
	public boolean execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.removeById(id);
	}
}
