package model;

import java.util.List;

import bean.Employee;
import dao.EmployeesDAO;

public class FindEmpByDeptIdLogic {
	public List<Employee> execute(int deptId) {
		EmployeesDAO dao = new EmployeesDAO();
		return dao.findByDeptId(deptId);
	}
}
