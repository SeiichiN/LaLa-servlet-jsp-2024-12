package model;

import bean.EmployeeForm;
import dao.EmployeesDAO;

public class PostEmpLogic {
	public boolean execute(EmployeeForm empForm) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.create(empForm);
	}
}
