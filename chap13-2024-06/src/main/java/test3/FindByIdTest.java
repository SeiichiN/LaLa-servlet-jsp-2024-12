package test3;

import dao.EmployeesDAO;
import model.Employee;

public class FindByIdTest {

	public static void main(String[] args) {
		
		EmployeesDAO dao = new EmployeesDAO();
		String id = "emp003";
		Employee emp = dao.findById(id);
		System.out.println(emp);
	}

}
