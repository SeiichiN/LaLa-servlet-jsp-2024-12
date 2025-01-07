package test3;

import dao.EmployeesDAO;
import model.Employee;

public class CreateTest {

	public static void main(String[] args) {
		EmployeesDAO dao = new EmployeesDAO();
		Employee emp = new Employee("EMP003", "菅原 拓真", 34);
		boolean result = dao.create(emp);
		if (result) {
			System.out.println("登録成功");
		} else {
			System.out.println("登録失敗");
		}
	}

}
