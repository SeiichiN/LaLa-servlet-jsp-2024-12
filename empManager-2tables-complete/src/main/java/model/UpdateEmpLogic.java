package model;

import bean.EmployeeForm;
import dao.EmployeesDAO;

public class UpdateEmpLogic {
	public boolean execute(EmployeeForm empForm) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.update(empForm);
	}
}
