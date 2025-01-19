package model;

import bean.Employee;
import dao.EmployeesDAO;

public class FindEmpByIdLogic {
	public Employee execute(int empId) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findById(empId);
	}
}
