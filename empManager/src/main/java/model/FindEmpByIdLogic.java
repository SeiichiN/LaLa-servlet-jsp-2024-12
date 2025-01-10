package model;

import dao.EmployeesDAO;

public class FindEmpByIdLogic {
	public Employee execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findById(id);
	}
}
