package model;

import dao.EmployeeDAO;

public class GetEmployeeByIdLogic {
	public Employee execute(String id) {
		EmployeeDAO dao = new EmployeeDAO();
		Employee emp = dao.findById(id);
		return emp;
	}
}
