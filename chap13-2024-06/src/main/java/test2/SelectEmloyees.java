package test2;

import java.util.List;

import dao.EmployeesDAO;
import model.Employee;

public class SelectEmloyees {

	public static void main(String[] args) {
		
		EmployeesDAO empDAO = new EmployeesDAO();
		List<Employee> empList = empDAO.findAll();
		
		for (Employee emp : empList) {
			System.out.println("ID:" + emp.getId());
			System.out.println("名前:" + emp.getName());
			System.out.println("年齢:" + emp.getAge());
			System.out.println("---------------------");
		}
	}

}
