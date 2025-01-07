package model;

import java.util.List;

import dao.EmployeesDAO;

public class GetListLogic {

	public List<Employee> execute() {
		EmployeesDAO empDAO = new EmployeesDAO();
		List<Employee> empList = empDAO.findAll();
		return empList;
	}
}
