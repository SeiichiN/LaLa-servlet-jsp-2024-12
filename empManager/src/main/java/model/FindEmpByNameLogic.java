package model;

import java.util.List;

import dao.EmployeesDAO;

public class FindEmpByNameLogic {
	public List<Employee> execute(String name) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findByName(name);
	}
}
