package test;

import dao.EmployeesDAO;
import model.Employee;

public class FindByIdTest {

	public static void main(String[] args) {
		String id = "EMP002";
		EmployeesDAO dao = new EmployeesDAO();
		Employee employee = dao.findById(id);
		System.out.println(employee);
		// EmployeeクラスにtoString()メソッドが定義されている。
	}

}
