package test2;

import java.util.List;

import model.Employee;
import model.GetEmployeeListLogic;

public class SelectEmployeeSample {

	public static void main(String[] args) {
		GetEmployeeListLogic logic = new GetEmployeeListLogic();
		List<Employee> empList = logic.execute();

		for (Employee emp : empList) {
			System.out.println("ID:" + emp.getId());
			System.out.println("名前:" + emp.getName());
			System.out.println("年齢:" + emp.getAge());
			System.out.println();
		}
	}

}
