package model;

import dao.EmployeesDAO;

public class GetEmpByIdLogic {

	public Employee execute(String id) {
		EmployeesDAO dao = new EmployeesDAO();
		Employee emp = dao.findById(id);
		return emp;
	}	
}
