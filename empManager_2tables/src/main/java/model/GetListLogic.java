package model;

import java.util.List;

import bean.Employee;
import dao.EmployeesDAO;

public class GetListLogic {
	public List<Employee> execute() {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findAll();
	}
}
