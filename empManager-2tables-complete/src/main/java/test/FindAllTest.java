package test;

import java.util.List;

import bean.Employee;
import dao.EmployeesDAO;

public class FindAllTest {

	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		List<Employee> empList = dao.findAll();
		for (Employee emp : empList) {
			System.out.println(emp);
		}

	}

}
