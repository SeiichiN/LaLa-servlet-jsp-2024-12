package model;

import java.util.List;

import bean.Employee;
import dao.EmployeesDAO;

public class FindAllLogic {
	public List<Employee> execute() {
		EmployeesDAO dao = new EmployeesDAO();
		List<Employee> empList = dao.findAll();
		return empList;
	}
}
